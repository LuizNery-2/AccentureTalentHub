package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.AulasRecordDto;
import com.accenture.accenturetalenthub.models.AulaModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.accenture.accenturetalenthub.repositories.AulasRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class AulaController {
    @Autowired
    AulasRepository aulasRepository;

    @PostMapping("/aula")
    public ResponseEntity<AulaModel> saveAula(@RequestBody AulasRecordDto aulasRecordDto)
    {
        var aulaModel = new AulaModel();
        BeanUtils.copyProperties(aulasRecordDto, aulaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(aulasRepository.save(aulaModel));

    }
    @GetMapping("/aula")
    public ResponseEntity<List<AulaModel>> getAllAulas()
    {
        return ResponseEntity.status(HttpStatus.OK).body(aulasRepository.findAll());
    }

    @GetMapping("/aula/{id}")
    public ResponseEntity<Object> getAula(@PathVariable(value = "id")UUID id){

        Optional<AulaModel> aulaO = aulasRepository.findById(id);
        if (aulaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula não encontrada");
        }
        var aulaModel = aulaO.get();
        return ResponseEntity.status(HttpStatus.OK).body(aulaModel);
    }
    @PutMapping("/aula/{id}")
    public ResponseEntity<Object> updateAula(@PathVariable(value = "id")UUID id, @RequestBody AulasRecordDto aulaRecordDto){
        Optional<AulaModel> aulaO = aulasRepository.findById(id);
        if (aulaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula não encontrada");
        }
        var aulaModel = aulaO.get();
        BeanUtils.copyProperties(aulaRecordDto,aulaModel);
        return ResponseEntity.status(HttpStatus.OK).body(aulaModel);
    }
    @DeleteMapping("/aula/{id}")
    public ResponseEntity<Object> deleteAula(@PathVariable(value = "id")UUID id)
    {
        Optional<AulaModel> aulaO = aulasRepository.findById(id);
        if (aulaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula não encontrada");
        }
        var aulaModel = aulaO.get();
        aulasRepository.delete(aulaModel);
        return ResponseEntity.status(HttpStatus.OK).body("Aula deletada com sucesso");
    }
}

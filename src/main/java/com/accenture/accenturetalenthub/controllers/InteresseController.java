package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.InteresseRecordDto;
import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class InteresseController {

    @Autowired
    InteresseRepository interesseRepository;

    @PostMapping("/interesses")
    public ResponseEntity<InteresseModel> saveInteresse(@RequestBody @Valid InteresseRecordDto interesseRecordDto){
        var interesseModel = new InteresseModel();
        BeanUtils.copyProperties(interesseRecordDto, interesseModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(interesseRepository.save(interesseModel));
    }
    @GetMapping("/interesses")
    public ResponseEntity<List<InteresseModel>> getAllInteresses(){
        return ResponseEntity.status(HttpStatus.OK).body(interesseRepository.findAll());
    }
    @GetMapping("/interesses/{id}")
    public ResponseEntity<Object> getInteresse(@PathVariable(value = "id") Long id) {
        Optional<InteresseModel> interesseO = interesseRepository.findById(id);
        if (interesseO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(interesseO.get());
    }
    @PutMapping("/interesses/{id}")
    public ResponseEntity<Object> updateInteresse(@PathVariable(value = "id") Long id, @RequestBody @Valid InteresseRecordDto interesseRecordDto) {
        Optional<InteresseModel> interesseO = interesseRepository.findById(id);
        if (interesseO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("interesse não encontrado");
        }
        var interesseModel = interesseO.get();
        BeanUtils.copyProperties(interesseRecordDto, interesseModel);
        return ResponseEntity.status(HttpStatus.OK).body(interesseRepository.save(interesseModel));
    }

    @DeleteMapping("/interesses/{id}")
    public ResponseEntity<Object> deleteInteresses(@PathVariable(value = "id") Long id){
        Optional<InteresseModel> interesseO = interesseRepository.findById(id);
        if (interesseO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse não encontrado");
        }
        var interesseModel = interesseO.get();
        interesseRepository.delete(interesseModel);
        return ResponseEntity.status(HttpStatus.OK).body("Interesse deletado com sucesso");

    }

}

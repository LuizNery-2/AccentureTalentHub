package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.SalaRecordDto;
import com.accenture.accenturetalenthub.models.SalaModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.accenture.accenturetalenthub.repositories.SalaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin("*")
public class SalaController {
    @Autowired
    SalaRepository salaRepository;

    @PostMapping("/salas")
    public ResponseEntity<UUID> saveSala(@RequestBody SalaRecordDto salaRecordDto) {
        var salaModel = new SalaModel();
        BeanUtils.copyProperties(salaRecordDto, salaModel);
        SalaModel salaCriada = salaRepository.save(salaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaCriada.getIdSala());
    } 
        

    @GetMapping("/salas")
    public ResponseEntity<List<SalaModel>> getAllSalas()
    {
        return ResponseEntity.status(HttpStatus.OK).body(salaRepository.findAll());
    }
    @GetMapping("/salas/{id}")
    public ResponseEntity<Object> getSala(@PathVariable(value ="id")UUID id){
        Optional<SalaModel> salaO = salaRepository.findById(id);
        if(salaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("sala não encontrada");
        }
        var salaModel = salaO.get();
        return ResponseEntity.status(HttpStatus.OK).body(salaModel);
    }
    @PutMapping("/salas/{id}")
    public ResponseEntity<Object> updateSala(@PathVariable(value = "id") UUID id, @RequestBody SalaRecordDto salaRecordDto)
    {   Optional<SalaModel> salaO = salaRepository.findById(id);
        if (salaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrado");
        }
        var salaModel = salaO.get();
        BeanUtils.copyProperties(salaRecordDto, salaModel);
        return ResponseEntity.status(HttpStatus.OK).body("curso atualizado");

    }

    @DeleteMapping("/salas/{id}")
    public ResponseEntity<Object> deleteSala(@PathVariable(value = "id") UUID id)
    {
        Optional<SalaModel> salaO = salaRepository.findById(id);
        if (salaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrado");
        }
        var salaModel = salaO.get();
        salaRepository.delete(salaModel);
        return ResponseEntity.status(HttpStatus.OK).body("Modulo deletado com sucesso");
    }
}

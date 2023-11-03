package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.ModulosRecordDto;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.models.ModulosModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.accenture.accenturetalenthub.repositories.ModulosRepository;

@RestController
@CrossOrigin("*")
public class ModuloController {
    @Autowired
    ModulosRepository modulosRepository;

    @PostMapping("/modulos")
    public ResponseEntity<ModulosModel> saveModulo(@RequestBody ModulosRecordDto modulosRecordDto)
    {
        var modulosModel = new ModulosModel();
        BeanUtils.copyProperties(modulosModel,modulosRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(modulosRepository.save(modulosModel));
    }

    @GetMapping("/modulos")
    public ResponseEntity<List<ModulosModel>> getAllModulos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(modulosRepository.findAll());
    }

    @GetMapping("/modulos/{id}")
    public ResponseEntity<Object> getModulo(@PathVariable( value = "id") UUID id)
    {
        Optional<ModulosModel> moduloO = modulosRepository.findById(id);
        if (moduloO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var moduloModel = moduloO.get();
        return ResponseEntity.status(HttpStatus.OK).body(moduloModel);

    }
    @PutMapping("/modulos/{id}")
    public ResponseEntity<Object> updateModulo(@PathVariable(value = "id") UUID id, @RequestBody ModulosRecordDto modulosRecordDto)
    {
        Optional<ModulosModel> modelO = modulosRepository.findById(id);
        if (modelO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var interesseModel = modelO.get();
        BeanUtils.copyProperties(interesseModel,modulosRecordDto);
        return ResponseEntity.status(HttpStatus.OK).body(modulosRepository.save(interesseModel));
    }
}

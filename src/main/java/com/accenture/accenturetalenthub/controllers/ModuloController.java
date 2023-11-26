package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.ModuloRecordDto;
import com.accenture.accenturetalenthub.models.ModuloModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.accenture.accenturetalenthub.repositories.ModuloRepository;

@RestController
@CrossOrigin("*")
public class ModuloController {
    @Autowired
    ModuloRepository moduloRepository;

    @PostMapping("/modulos")
    public ResponseEntity<ModuloModel> saveModulo(@RequestBody ModuloRecordDto modulosRecordDto)
    {
        var modulosModel = new ModuloModel();
        BeanUtils.copyProperties(modulosRecordDto, modulosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(moduloRepository.save(modulosModel));
    }

    @GetMapping("/modulos")
    public ResponseEntity<List<ModuloModel>> getAllModulos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(moduloRepository.findAll());
    }

    @GetMapping("/modulos/{id}")
    public ResponseEntity<Object> getModulo(@PathVariable( value = "id") UUID id)
    {
        Optional<ModuloModel> moduloO = moduloRepository.findById(id);
        if (moduloO.isEmpty()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var moduloModel = moduloO.get();
        return ResponseEntity.status(HttpStatus.OK).body(moduloModel);

    }
    @PutMapping("/modulos/{id}")
    public ResponseEntity<Object> updateModulo(@PathVariable(value = "id") UUID id, @RequestBody ModuloRecordDto modulosRecordDto)
    {
        Optional<ModuloModel> modelO = moduloRepository.findById(id);
        if (modelO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var interesseModel = modelO.get();
        BeanUtils.copyProperties(modulosRecordDto,interesseModel);
        return ResponseEntity.status(HttpStatus.OK).body(moduloRepository.save(interesseModel));
    }

    @DeleteMapping("/modulos/{id}")
    public ResponseEntity<Object> deleteModulo(@PathVariable(value = "id") UUID id)
    {
        Optional<ModuloModel> modeloO = moduloRepository.findById(id);
        if (modeloO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var moduloModel =  new ModuloModel();
        moduloRepository.delete(moduloModel);
        return ResponseEntity.status(HttpStatus.OK).body("Modulo deletado com sucesso");
    }
}

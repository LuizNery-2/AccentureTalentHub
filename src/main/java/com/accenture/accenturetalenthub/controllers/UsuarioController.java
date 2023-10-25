package com.accenture.accenturetalenthub.controllers;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.accenturetalenthub.dtos.UsuarioRecordDto;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.UsuarioRepository;




@RestController
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioRecordDto usuarioRecordDto){
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));

    }

    @GetMapping("/usuario")
    public ResponseEntity<List<UsuarioModel>> getAllUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll());
    }

    @GetMapping("/usuario/{Id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "Id") UUID IdUsuario){
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(IdUsuario);
        if(usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioO.get());
    }

    @PutMapping("/usuario/{Id}")
    public ResponseEntity<Object> upadateUsuario(@PathVariable(value = "Id") UUID IdUsuario, @RequestBody UsuarioRecordDto usuarioRecordDto){
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(IdUsuario);
        if(usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        var usuarioModel = usuarioO.get();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
        
    }

    @DeleteMapping("/usuario/{Id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "Id") UUID IdUsuario){
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(IdUsuario);
        if(usuarioO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
        usuarioRepository.delete(usuarioO.get());

        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
        
    }

}


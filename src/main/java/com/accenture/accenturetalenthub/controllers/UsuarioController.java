package com.accenture.accenturetalenthub.controllers;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    // @PostMapping("/usuario")
    // public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioRecordDto usuarioRecordDto){
    //     var usuarioModel = new UsuarioModel();
    //     BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);

    //     return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));

    // }

    @PostMapping("/usuario")
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody UsuarioRecordDto usuarioRecordDto){
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);

        UsuarioModel savedUsuario = usuarioRepository.save(usuarioModel);

        // Verifica se o usuário foi salvo corretamente antes de retornar
        if(savedUsuario.getIdUsuario() != null){
            // Retorna o usuário e o status 201 Created
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
        } else {
            // Em caso de falha ao salvar, retorna um status de erro
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

    @PostMapping("/login")
    public ResponseEntity<?> validarLogin(@RequestBody UsuarioRecordDto usuarioRecordDto) {
        // Obtenha os dados de usuário e senha do loginRequest
        String nomeUsuario = usuarioRecordDto.getUsuario();
        String senha = usuarioRecordDto.getSenha();

        // Pesquise no banco de dados com base nos dados recebidos
        Optional<UsuarioModel> usuario = usuarioRepository.findByUsuarioAndSenha(nomeUsuario, senha);

        if (usuario.isPresent()) {
            // Usuário encontrado, retorne os detalhes do usuário
            return ResponseEntity.ok(usuario.get());
        } else {
            // Usuário não encontrado, retorne uma resposta apropriada
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
        }
    }

}


package com.accenture.accenturetalenthub.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.accenturetalenthub.dtos.ComentarioForumDto;
import com.accenture.accenturetalenthub.models.ComentarioForum;
import com.accenture.accenturetalenthub.repositories.ComentarioForumRepository;
import com.accenture.accenturetalenthub.services.ComentarioForumService;


@RestController
public class ComentarioForumController {
    @Autowired
    ComentarioForumRepository  comentarioForumRepository;

    @Autowired
    ComentarioForumService comentarioForumService;


    @PostMapping("/comentario")
    public ResponseEntity<ComentarioForum> saveComentario(@RequestBody ComentarioForumDto comentarioForumDto){
        comentarioForumService.criarComentario(comentarioForumDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/comentario")
    public ResponseEntity<List<ComentarioForum>> getAllUsuario(){
        return ResponseEntity.status(HttpStatus.OK).body(comentarioForumRepository.findAll());
    }
    
    @DeleteMapping("/comentario/{Id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "Id") UUID IdComentarioForum){
        Optional<ComentarioForum> comentarioAchado = comentarioForumRepository.findById(IdComentarioForum);
        if(comentarioAchado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comentário não encontrado!");
        }
        comentarioForumRepository.delete(comentarioAchado.get());

        return ResponseEntity.status(HttpStatus.OK).body("Comentário deletado com sucesso!");
        
    }


}

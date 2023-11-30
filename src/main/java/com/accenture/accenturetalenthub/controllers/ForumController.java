package com.accenture.accenturetalenthub.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.accenture.accenturetalenthub.models.ForumModel;
import com.accenture.accenturetalenthub.repositories.ForumRepository;

@RestController
public class ForumController {
    @Autowired
    ForumRepository forumRepository;

    @GetMapping("/foruns")
    public ResponseEntity<List<ForumModel>> getAllCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(forumRepository.findAll());
    }

    @GetMapping("/foruns/{id}")
    public ResponseEntity<Object> getCursos(@PathVariable(value = "id") UUID id) {
        Optional<ForumModel> forumOp = forumRepository.findById(id);
        if (forumOp.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("fórum não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(forumOp.get());
    }
}

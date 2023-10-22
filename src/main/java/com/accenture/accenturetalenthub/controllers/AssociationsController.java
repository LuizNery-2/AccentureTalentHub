package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import com.accenture.accenturetalenthub.services.AssociatesEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
public class AssociationsController {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InteresseRepository interesseRepository;

    AssociatesEntitiesService associatesEntitiesService =  new AssociatesEntitiesService();

    @PostMapping("/cursosInteresses/{idCurso}/{idInteresse}")
    public ResponseEntity<String> associarCocietesCursoInteresses(@PathVariable(value = "idCurso") UUID idCurso, @PathVariable(value ="idInteresse") Long idInteresse){

        Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);
        Optional<InteresseModel> interesseO = interesseRepository.findById(idInteresse);

        if (cursoO.isEmpty() || interesseO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso ou interesse não encontrado");
        }
        var cursoModel = cursoO.get();
        var interesseModel = interesseO.get();
        associatesEntitiesService.associarCursoInteresse(cursoModel,interesseModel);

        return ResponseEntity.status(HttpStatus.OK).body("Interesse adicionado ao Curso com sucesso");
    }

}

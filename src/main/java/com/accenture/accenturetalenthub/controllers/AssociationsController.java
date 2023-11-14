package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import com.accenture.accenturetalenthub.repositories.UsuarioRepository;
import com.accenture.accenturetalenthub.services.AssociatesEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AssociationsController {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InteresseRepository interesseRepository;

   

    @Autowired
    UsuarioRepository usuarioRepository;
    private AssociatesEntitiesService associatesEntitiesService;

    public AssociationsController(AssociatesEntitiesService associatesEntitiesService) {
        this.associatesEntitiesService = associatesEntitiesService;
    }

    @PostMapping("/cursosInteresses/{idCurso}")
    public ResponseEntity<String> saveCursoInteresses(@PathVariable(value = "idCurso") UUID idCurso, @RequestBody List<Long> idsInteresses) {

        Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);

        if (cursoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }

        var cursoModel = cursoO.get();

        for (Long idInteresse : idsInteresses) {
            Optional<InteresseModel> interesseO = interesseRepository.findById(idInteresse);
            if (interesseO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse com ID " + idInteresse + " não encontrado");
            }
            var interesseModel = interesseO.get();
            associatesEntitiesService.associarCursoInteresse(cursoModel, interesseModel);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Interesses adicionados ao Curso com sucesso");
    }

    @PostMapping("usuariosInteresses/{idUsuario}")
    public ResponseEntity<String> saveUsuarioInteresse(@PathVariable(value = "idUsuario") UUID idUsuario, @RequestBody List<Long> idsInteresses)
    {
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(idUsuario);
        if (usuarioO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        var usuarioModel = usuarioO.get();
        for (long idInteresse : idsInteresses)
        {
            Optional<InteresseModel> interesseO = interesseRepository.findById(idInteresse);
            if (interesseO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse com ID " + idInteresse + " não encontrado");
            }
            var interesseModel = interesseO.get();
            associatesEntitiesService.associarUsuarioInteresses(usuarioModel, interesseModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Interesses adcionados ao usuário com sucesso");
    }


}
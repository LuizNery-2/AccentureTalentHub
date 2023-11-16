package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.models.SalaModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import com.accenture.accenturetalenthub.repositories.SalaRepository;
import com.accenture.accenturetalenthub.repositories.UsuarioRepository;
import com.accenture.accenturetalenthub.services.AssociatesEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
public class AssociationsController {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InteresseRepository interesseRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    AssociatesEntitiesService associatesEntitiesService;




    @PostMapping("/cursosInteresses/{idCurso}")
    public ResponseEntity<String> saveCursoInteresses(@PathVariable(value = "idCurso") long idCurso, @RequestBody List<Long> idsInteresses) {

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
    @PostMapping("cursosSalas/{idSalas}")
    public ResponseEntity<String> saveCursosSalas(@PathVariable(value = "idSalas") UUID idSala,@RequestBody List<Long> idCursos)
    {
        Optional<SalaModel> salaO = salaRepository.findById(idSala);

        if (salaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrado");
        }

        var salaModel = salaO.get();

        for (Long idCurso : idCursos) {
            Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);
            if (cursoO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso com ID " + idCurso + " não encontrado");
            }
            var cursoModel = cursoO.get();
            associatesEntitiesService.associarCursoSalas(cursoModel,salaModel);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Interesses adicionados ao Curso com sucesso");
    }




    @PostMapping("usuariosInteresses/{idUsuario}")
    public ResponseEntity<String> saveUsuarioInteresse(@PathVariable(value = "idUsuario") UUID idUsuario,@RequestBody List<Long> idsInteresses)
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

    @DeleteMapping("usuariosInteresses/{idUsuario}")
    public ResponseEntity<String> deleteUsuarioInteresse(@PathVariable(value = "idUsuario") UUID idUsuario,@RequestBody List<Long> idsInteresses)
    {
        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(idUsuario);
        List<InteresseModel> interessesAssociados = new ArrayList<>();
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
            if (!interesseModel.getUsuarios().contains(usuarioModel))
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse com ID " + interesseModel.getIdInteresse() + " não encontrado no usuario com ID " + usuarioModel.getIdUsuario());
            }
            interessesAssociados.add(interesseModel);


        }
        for (InteresseModel interesseModel : interessesAssociados)
        {
            associatesEntitiesService.associarUsuarioInteresses(usuarioModel, interesseModel);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Interesses deletados do usuário com sucesso");
    }


     @PostMapping("usuariosCursos/{idUsuario}")
    public ResponseEntity<String> saveUsuarioCursos(
            @PathVariable(value = "idUsuario") UUID idUsuario,
            @RequestBody Map<String, String> requestBody) {

        // Certifique-se de que a chave "idsInteresses" está presente no corpo da solicitação
        if (!requestBody.containsKey("idsCursos")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A chave 'idsCursos' é obrigatória no corpo da solicitação");
        }

        // Obtenha a string de IDs de interesse a partir do corpo da solicitação
        String idsCursosString = requestBody.get("idsCursos");

        // Converta a string em uma lista de IDs de interesse
        List<Long> idsCursos = Arrays.stream(idsCursosString.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());

        Optional<UsuarioModel> usuarioO = usuarioRepository.findById(idUsuario);
        if (usuarioO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        var usuarioModel = usuarioO.get();

        for (long idCurso : idsCursos) {
            Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);
            if (cursoO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Interesse com ID " + idCurso + " não encontrado");
            }

            var CursoModel = cursoO.get();
            associatesEntitiesService.associarUsuarioCurso(usuarioModel, CursoModel);
        }

        return ResponseEntity.status(HttpStatus.OK).body("Interesses adicionados ao usuário com sucesso");
    }


}

package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.models.*;
import com.accenture.accenturetalenthub.repositories.*;
import com.accenture.accenturetalenthub.services.AssociatesEntitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    ModuloRepository moduloRepository;

    @Autowired
    AssociatesEntitiesService associatesEntitiesService;
    @Autowired
    AulasRepository aulasRepository;




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
    @PostMapping("cursosSalas/{idSalas}")
    public ResponseEntity<String> saveCursosSalas(@PathVariable(value = "idSalas") UUID idSala,@RequestBody List<UUID> idCursos)
    {
        Optional<SalaModel> salaO = salaRepository.findById(idSala);

        if (salaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrado");
        }

        var salaModel = salaO.get();

        for (UUID idCurso : idCursos) {
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
    public ResponseEntity<String> saveUsuarioCursos(@PathVariable(value = "idUsuario") UUID idUsuario, @RequestBody List<UUID> idsCursos ) {

         Optional<UsuarioModel> usuarioO = usuarioRepository.findById(idUsuario);
         if (usuarioO.isEmpty())
         {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
         }
         var usuarioModel = usuarioO.get();
         for (UUID idCurso: idsCursos ) {
             Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);
             if (cursoO.isEmpty())
             {
                 return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso com o ID " + idCurso + " não encontrado");
             }
             var cursoModel = cursoO.get();
             associatesEntitiesService.associarUsuarioCurso(usuarioModel,cursoModel);

         }
         return ResponseEntity.status(HttpStatus.OK).body("Curso concluido com sucesso");

    }
    @PostMapping("usuariosSalas/{idSala}")
    public ResponseEntity<String> cadastrarUsuariosSalas(@PathVariable(value= "idSala")UUID idSala, @RequestBody List<UUID> idsUsuarios ){
        Optional<SalaModel> salaO = salaRepository.findById(idSala);
        if (salaO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrada");
        }
        var salaModel = salaO.get();
        for (UUID idUsuario : idsUsuarios)
        {
            Optional<UsuarioModel> usuarioO = usuarioRepository.findById(idUsuario);
            if (usuarioO.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario com ID" + idUsuario + "não encontrado");
            }
            var usuarioModel = usuarioO.get();
            associatesEntitiesService.associarUsuariosSalas(usuarioModel,salaModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Usuarios cadastrados com sucesso");
    }

    @PostMapping("/salasCursos/{idSala}")
    public ResponseEntity<String> cadastrarCursosSalas(@PathVariable(value = "idSala") UUID idSala,@RequestBody List<UUID> idCursos){
        Optional<SalaModel> salaO = salaRepository.findById(idSala);
        if (salaO.isEmpty())
        {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sala não encontrado");
        }
        var salaModel = salaO.get();
        for (UUID idCurso : idCursos)
        {
            Optional<CursoModel> cusoO = cursoRepository.findById(idCurso);
            if (cusoO.isEmpty())
            {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso com o ID " + idCurso + " não encontrado");
            }
            var cursoModel =  cusoO.get();
            associatesEntitiesService.associarCursoSalas(cursoModel, salaModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Curso cadastrado com sucesso");
    }
    @PostMapping("/cursosmodulos/{idCurso}")
    public ResponseEntity<String> cadastrarCursoModulo(@PathVariable(value = "idCurso")UUID idCurso,@RequestBody List<UUID> idsModulos) {
        Optional<CursoModel> cursoO = cursoRepository.findById(idCurso);

        if (cursoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        var cursoModel = cursoO.get();
        for (UUID idModulo : idsModulos) {
            Optional<ModuloModel> modelO = moduloRepository.findById(idModulo);
            if (modelO.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo com o ID: " + idModulo + " não encontrado");
            }
            var moduloModel = modelO.get();
            associatesEntitiesService.associarCursoModulos(cursoModel, moduloModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Modulo cadastrado com sucesso");
    }
    @PostMapping("/modulosaulas/{idModulo}")
    public ResponseEntity<Object> castrarAulasModulos(@PathVariable(value = "idModulo") UUID idModulo, List<UUID> idsAulas)
    {
        Optional<ModuloModel> moduloO = moduloRepository.findById(idModulo);
        if (moduloO.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Modulo não encontrado");
        }
        var moduloModel = moduloO.get();
        for (UUID idAula: idsAulas) {
            Optional<AulaModel> aulaO = aulasRepository.findById(idAula);
            if (aulaO.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aula com ID: " + idAula + " não encontrada");
            }
            var aulaModel = aulaO.get();
            associatesEntitiesService.associarModulosAulas(moduloModel, aulaModel);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Aula cadastrada com sucesso");
    }

}

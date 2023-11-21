package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.dtos.CursoRecordDto;
import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
public class CursoController{
    @Autowired
    CursoRepository cursoRepository;

    // @PostMapping("/cursos")
    // public ResponseEntity<CursoModel> saveCurso(@RequestBody @Valid CursoRecordDto cursoRecordDto)
    // {
    //     var cursoModel  = new CursoModel();
    //     BeanUtils.copyProperties(cursoRecordDto, cursoModel);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(cursoRepository.save(cursoModel));

    // }
    @PostMapping("/cursos")
    public ResponseEntity<Long> saveCurso(@RequestBody @Valid CursoRecordDto cursoRecordDto) {
        var cursoModel = new CursoModel();
        BeanUtils.copyProperties(cursoRecordDto, cursoModel);

        // Salva o curso no banco de dados
        cursoModel = cursoRepository.save(cursoModel);

        // Retorna o ID do curso recém-criado
        Long newCursoId = cursoModel.getIdCurso();

        // Você também pode optar por redirecionar para o método getLastCursoId para obter o último ID.
        // Isso evita duplicação de lógica, mas pode ser menos eficiente.
        return ResponseEntity.status(HttpStatus.CREATED).body(newCursoId);
    }

    @GetMapping("/cursos/last-id")
    public ResponseEntity<Long> getLastCursoId() {
        CursoModel lastCurso = cursoRepository.findFirstByOrderByIdCursoDesc();

        if (lastCurso == null) {
            // Se não houver cursos cadastrados, você pode decidir o que fazer.
            // Neste exemplo, estou retornando um código 404.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Long lastId = lastCurso.getIdCurso();
        return ResponseEntity.status(HttpStatus.OK).body(lastId);
    }

    @GetMapping("/cursos")
    public ResponseEntity<List<CursoModel>> getAllCursos()
    {
        return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.findAll());
    }

    @GetMapping("/cursos/{id}")
    public ResponseEntity<Object> getCursos(@PathVariable(value = "id") long id) {
        Optional<CursoModel> cursoO = cursoRepository.findById(id);
        if (cursoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cursoO.get());
    }
    
    @PutMapping("/cursos/{id}")
    public ResponseEntity<Object> updateCurso(@PathVariable(value = "id") long id, @RequestBody @Valid CursoRecordDto cursoRecordDto){
        Optional<CursoModel> cursoO = cursoRepository.findById(id);
        if (cursoO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        var cursoModel = cursoO.get();
        BeanUtils.copyProperties(cursoRecordDto, cursoModel);
        return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.save(cursoModel));
    }
    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Object> deleteCurso(@PathVariable(value = "id") long id){
        Optional<CursoModel> curso0 = cursoRepository.findById(id);
        if (curso0.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Curso não encontrado");
        }
        cursoRepository.delete(curso0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Curso deletado com sucesso");
    }






}

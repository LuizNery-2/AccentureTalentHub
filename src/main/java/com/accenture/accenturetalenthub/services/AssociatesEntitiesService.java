package com.accenture.accenturetalenthub.services;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AssociatesEntitiesService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InteresseRepository interesseRepository;


    @Transactional
    public void associarCursoInteresse(CursoModel curso, InteresseModel interesse){

        curso.getInteresses().add(interesse);
        cursoRepository.save(curso);
    }

}

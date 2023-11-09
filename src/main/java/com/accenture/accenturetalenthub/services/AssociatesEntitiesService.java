package com.accenture.accenturetalenthub.services;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.models.SalaModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
import com.accenture.accenturetalenthub.repositories.SalaRepository;
import com.accenture.accenturetalenthub.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociatesEntitiesService {

    @Autowired
    CursoRepository cursoRepository;
    @Autowired
    InteresseRepository interesseRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    SalaRepository salaRepository;



    @Transactional
    public void associarCursoInteresse(CursoModel curso, InteresseModel interesse){

        curso.getInteresses().add(interesse);
        interesse.getCursos().add(curso);
        cursoRepository.save(curso);
        interesseRepository.save(interesse);
    }

    @Transactional
    public void associarCursoSalas(CursoModel curso, SalaModel sala)
    {
        curso.getSalas().add(sala);
        sala.getCurso().add(curso);
        cursoRepository.save(curso);
        salaRepository.save(sala);
    }

    @Transactional
    public void associarUsuarioCurso(UsuarioModel usuario, CursoModel curso)
    {
        usuario.getCursos().add(curso);
        curso.getUsuarios().add(usuario);
        usuarioRepository.save(usuario);
        cursoRepository.save(curso);
    }

    @Transactional
    public void associarUsuarioInteresses(UsuarioModel usuario, InteresseModel interesse)
    {
            usuario.getInteresses().add(interesse);
            interesse.getUsuarios().add(usuario);

            usuarioRepository.save(usuario);

    }


}

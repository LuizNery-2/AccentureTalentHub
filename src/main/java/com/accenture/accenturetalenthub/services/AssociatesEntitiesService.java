package com.accenture.accenturetalenthub.services;

import com.accenture.accenturetalenthub.models.CursoModel;
import com.accenture.accenturetalenthub.models.InteresseModel;
import com.accenture.accenturetalenthub.models.SalaModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.CursoRepository;
import com.accenture.accenturetalenthub.repositories.InteresseRepository;
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


    @Transactional
    public void associarCursoInteresse(CursoModel curso, InteresseModel interesse){

        curso.getInteresses().add(interesse);
        cursoRepository.save(curso);
    }

    @Transactional
    public void associarCursoSalas(CursoModel curso, SalaModel sala)
    {
        curso.getSalas().add(sala);
        cursoRepository.save(curso);
    }

    @Transactional
    public void associarUsuarioCursoConcluidos(UsuarioModel usuario, CursoModel curso)
    {
        usuario.getCursos().add(curso);
        usuarioRepository.save(usuario);
    }

    @Transactional
    public void associarUsuarioInteresses(UsuarioModel usuario, InteresseModel interesse)
    {
            usuario.getInteresses().add(interesse);
            usuarioRepository.save(usuario);
    }


}

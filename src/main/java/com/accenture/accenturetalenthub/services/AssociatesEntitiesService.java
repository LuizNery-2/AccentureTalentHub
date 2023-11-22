package com.accenture.accenturetalenthub.services;

import com.accenture.accenturetalenthub.models.*;
import com.accenture.accenturetalenthub.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociatesEntitiesService {

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    InteresseRepository interesseRepository;

    @Autowired
    SalaRepository salaRepository;
    @Autowired
    ModuloRepository moduloRepository;
    @Autowired
    AulasRepository aulasRepository;



    @Transactional
    public void associarCursoInteresse(CursoModel curso, InteresseModel interesse){

        curso.getInteresses().add(interesse);
        interesse.getCursos().add(curso);
        cursoRepository.save(curso);
        interesseRepository.save(interesse);
    }
    @Transactional
    public void removerAssociacaoCursoInteresse(CursoModel curso, InteresseModel interesse){
        curso.getInteresses().remove(interesse);
        interesse.getCursos().remove(curso);
        cursoRepository.save(curso);
        interesseRepository.save(interesse);
    }

    @Transactional
    public void associarCursoSalas(CursoModel curso, SalaModel sala)
    {
        curso.getSalas().add(sala);
        sala.getCursos().add(curso);
        cursoRepository.save(curso);
        salaRepository.save(sala);
    }
    @Transactional
    public void removerAssociacaoCursoSalas(CursoModel curso, SalaModel sala)
    {
        curso.getSalas().remove(curso);
        sala.getCursos().remove(sala);
        cursoRepository.save(curso);
        salaRepository.save(sala);
    }

    @Transactional
    public void associarModulosAulas(ModuloModel modulo, AulaModel aula)
    {
        modulo.getAulas().add(aula);
        aula.setModulo(modulo);
        moduloRepository.save(modulo);
        aulasRepository.save(aula);
    }
    @Transactional
    public void removerAssociacaoModulosAulas(ModuloModel modulo, AulaModel aula)
    {
        modulo.getAulas().remove(aula);
        aula.setModulo(modulo);
        moduloRepository.save(modulo);
        aulasRepository.save(aula);
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
    public void removerAssociacaoUsuarioCurso(UsuarioModel usuario, CursoModel curso)
    {
        usuario.getCursos().remove(curso);
        curso.getUsuarios().remove(usuario);
        usuarioRepository.save(usuario);
        cursoRepository.save(curso);

    }

    @Transactional
    public void associarUsuarioInteresses(UsuarioModel usuario, InteresseModel interesse)
    {
            usuario.getInteresses().add(interesse);
            interesse.getUsuarios().add(usuario);

            usuarioRepository.save(usuario);
            interesseRepository.save(interesse);

    }
    @Transactional
    public void removerAssociacaoUsuarioInteresses(UsuarioModel usuario, InteresseModel interesse)
    {
        usuario.getInteresses().remove(interesse);
        interesse.getUsuarios().remove(usuario);

        usuarioRepository.save(usuario);
        interesseRepository.save(interesse);

    }
    @Transactional
    public void  associarUsuariosSalas(UsuarioModel usuario, SalaModel sala)
    {
        usuario.getSalas().add(sala);
        sala.getUsuarios().add(usuario);
        usuarioRepository.save(usuario);
        salaRepository.save(sala);
    }
    @Transactional
    public void  removerAssociacaoUsuariosSalas(UsuarioModel usuario, SalaModel sala)
    {
        usuario.getSalas().remove(sala);
        sala.getUsuarios().remove(usuario);
        usuarioRepository.save(usuario);
        salaRepository.save(sala);
    }

    public void associarCursoModulos(CursoModel curso, ModuloModel modulo){
        curso.getModulos().add(modulo);
        modulo.setCurso(curso);
        cursoRepository.save(curso);
        moduloRepository.save(modulo);

    }

}

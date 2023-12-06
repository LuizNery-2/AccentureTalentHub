package com.accenture.accenturetalenthub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.accenturetalenthub.dtos.ComentarioForumDto;
import com.accenture.accenturetalenthub.models.ComentarioForum;
import com.accenture.accenturetalenthub.models.ForumModel;
import com.accenture.accenturetalenthub.models.UsuarioModel;
import com.accenture.accenturetalenthub.repositories.ComentarioForumRepository;
import com.accenture.accenturetalenthub.repositories.ForumRepository;
import com.accenture.accenturetalenthub.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComentarioForumService {

    @Autowired
    private ComentarioForumRepository comentarioForumRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ForumRepository forumRepository;

    public void criarComentario(ComentarioForumDto comentarioDTO) {
        UsuarioModel usuario = usuarioRepository.findById(comentarioDTO.getIdUsuario())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        ForumModel forum = forumRepository.findById(comentarioDTO.getIdForum())
                .orElseThrow(() -> new EntityNotFoundException("Fórum não encontrado"));

        ComentarioForum comentario = new ComentarioForum();
        comentario.setForumModel(forum);
        comentario.setUsuarioModel(usuario);
        comentario.setMensagem(comentarioDTO.getMensagem());

        comentarioForumRepository.save(comentario);
    }
}

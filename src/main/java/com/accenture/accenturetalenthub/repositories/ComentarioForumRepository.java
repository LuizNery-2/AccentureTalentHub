package com.accenture.accenturetalenthub.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.accenturetalenthub.models.ComentarioForum;

@Repository
public interface ComentarioForumRepository extends JpaRepository<ComentarioForum, UUID> {
    Optional<ComentarioForum> findById(UUID idComentarioForum);
}

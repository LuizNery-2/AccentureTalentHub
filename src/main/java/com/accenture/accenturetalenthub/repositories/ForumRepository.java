package com.accenture.accenturetalenthub.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accenture.accenturetalenthub.models.ForumModel;

@Repository

public interface ForumRepository extends JpaRepository<ForumModel, UUID> {

}


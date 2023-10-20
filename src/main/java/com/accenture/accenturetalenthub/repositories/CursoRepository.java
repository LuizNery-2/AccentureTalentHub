package com.accenture.accenturetalenthub.repositories;

import com.accenture.accenturetalenthub.models.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, UUID> {
}

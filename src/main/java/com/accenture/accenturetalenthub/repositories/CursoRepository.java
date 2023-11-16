package com.accenture.accenturetalenthub.repositories;

import com.accenture.accenturetalenthub.models.CursoModel;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

    Optional<CursoModel> findById(long idCurso);
}

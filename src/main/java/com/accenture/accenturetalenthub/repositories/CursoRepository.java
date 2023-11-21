package com.accenture.accenturetalenthub.repositories;

import com.accenture.accenturetalenthub.models.CursoModel;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

    Optional<CursoModel> findById(long idCurso);
    @Query(value = "SELECT * FROM tb_cursos ORDER BY id_curso DESC LIMIT 1", nativeQuery = true)
    CursoModel findFirstByOrderByIdCursoDesc();
}

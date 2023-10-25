package com.accenture.accenturetalenthub.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.accenturetalenthub.models.AulasModel;

public interface AulasRepository extends JpaRepository<AulasModel, UUID>{
    
}

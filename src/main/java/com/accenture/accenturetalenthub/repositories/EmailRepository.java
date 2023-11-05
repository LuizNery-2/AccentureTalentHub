package com.accenture.accenturetalenthub.repositories;

import com.accenture.accenturetalenthub.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
    
}

package com.accenture.accenturetalenthub.repositories;

import com.accenture.accenturetalenthub.models.InteresseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseRepository extends JpaRepository<InteresseModel, Long> {
}

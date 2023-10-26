package com.accenture.accenturetalenthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.accenturetalenthub.repositories.AulasRepository;

@RestController
@CrossOrigin("*")
public class AulasController {
    @Autowired
    AulasRepository aulasRepository;
}

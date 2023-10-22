package com.accenture.accenturetalenthub.controllers;

import com.accenture.accenturetalenthub.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController{
    @Autowired
    CursoRepository cursoRepository;


}

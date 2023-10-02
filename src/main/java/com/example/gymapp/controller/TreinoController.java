package com.example.gymapp.controller;

import com.example.gymapp.model.Treino;
import com.example.gymapp.model.dto.NewTreinoDto;
import com.example.gymapp.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/treino")
public class TreinoController {

    @Autowired
    private TreinoService service;

    @GetMapping("/listar")
    public List<Treino> listar(){
        return service.listar();
    }

    @PostMapping()
    public void newTreino(@RequestBody NewTreinoDto treino){
        service.save(treino);
    }
}

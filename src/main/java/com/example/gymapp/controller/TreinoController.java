package com.example.gymapp.controller;

import com.example.gymapp.config.exception.ServiceException;
import com.example.gymapp.model.Treino;
import com.example.gymapp.model.User;
import com.example.gymapp.model.dto.NewTreinoDto;
import com.example.gymapp.model.dto.RequestCredentialsDto;
import com.example.gymapp.service.TreinoService;
import com.example.gymapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/treino")
public class TreinoController {

    @Autowired
    private TreinoService service;

    @Autowired
    private UserService userService;

    @GetMapping("/listar")
    public List<Treino> listar(){
        return service.listar();
    }

    @PostMapping()
    public void newTreino(@RequestBody NewTreinoDto treino){
        service.save(treino);
    }

    @GetMapping("/list/credentials")
    public List<Treino> listarByEmailAndPassword(@RequestBody RequestCredentialsDto treinoDto){
        User user = userService.getUser(treinoDto.getEmail(), treinoDto.getPassword());
         if(user == null){
            throw new ServiceException("User not found", HttpStatus.NOT_FOUND);
         }
        return service.listByUser(user);
    }
}

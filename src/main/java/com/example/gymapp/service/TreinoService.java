package com.example.gymapp.service;

import com.example.gymapp.model.Treino;
import com.example.gymapp.model.User;
import com.example.gymapp.model.dto.NewTreinoDto;
import com.example.gymapp.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    @Autowired
    private UserService userService;

    public void save(NewTreinoDto treinoDto){
        Treino treino = new Treino();
        treino.setNome(treinoDto.getNome());
        treino.setSerie(treinoDto.getSerie());
        treino.setTipoTreino(treinoDto.getTipoTreino());
        treino.setCarga(treinoDto.getCarga());
        treino.setUser(userService.getUser(treinoDto.getEmailUser(), treinoDto.getPassword()));

        repository.save(treino);
    }

    public List<Treino> listar(){
        return repository.findAll();
    }

    public List<Treino> listByUser(User user){
        return repository.findAllByUser(user);
    }

}

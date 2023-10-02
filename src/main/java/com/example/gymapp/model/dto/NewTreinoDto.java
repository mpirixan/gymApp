package com.example.gymapp.model.dto;

import com.example.gymapp.enums.TipoTreinoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NewTreinoDto{
    private String nome;
    private Integer serie;
    private Integer carga;
    private TipoTreinoEnum treinoEnum;
    private Long idUser;
}
package com.example.gymapp.model.dto;

import com.example.gymapp.enums.TipoTreinoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreinoEditDto {
    private String nome;
    private Integer serie;
    private Integer carga;
    private TipoTreinoEnum tipoTreino;
}

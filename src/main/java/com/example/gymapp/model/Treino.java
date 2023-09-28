package com.example.gymapp.model;

import com.example.gymapp.enums.TipoTreinoEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private Integer serie;
    private Integer carga;
    private TipoTreinoEnum tipoTreino;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

}

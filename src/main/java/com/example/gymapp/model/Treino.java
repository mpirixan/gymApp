package com.example.gymapp.model;

import com.example.gymapp.enums.TipoTreinoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "TREINO")
@Getter
@Setter
public class Treino extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "serie")
    private Integer serie;
    @Column(name = "carga")
    private Integer carga;
    @Column(name = "tipo_treino")
    private TipoTreinoEnum tipoTreino;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    @JsonIgnore
    private User user;

}

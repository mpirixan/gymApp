package com.example.gymapp.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RequestCredentialsDto {
    private String email;
    private String password;

}

package com.example.gymapp.model;

import org.modelmapper.ModelMapper;

import jakarta.persistence.MappedSuperclass;

/**
 * @author Kalwitalo Ibiapina
 * @version 1.0.0
 * @since 12/01/2021
 */

@MappedSuperclass
public abstract class BaseModel {

    public abstract Long getId();

    public <D> D toDto(ModelMapper modelMapper, Class<D> destinationType) {
        return modelMapper.map(this, destinationType);
    }

}

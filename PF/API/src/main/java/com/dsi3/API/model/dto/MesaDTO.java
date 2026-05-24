package com.dsi3.API.model.dto;

import com.dsi3.API.model.entity.Mesa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MesaDTO {
    private Long idMesa;
    
    private Integer numeroMesa;

    private Integer capacidad;

    private Mesa.EstadoMesa estado; 
}
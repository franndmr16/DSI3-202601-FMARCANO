package com.dsi3.API.model.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long idProducto;
    private String nombre;
    private String descripcion;
    private Double precio;
    private String categoria;
    private boolean disponible;
}
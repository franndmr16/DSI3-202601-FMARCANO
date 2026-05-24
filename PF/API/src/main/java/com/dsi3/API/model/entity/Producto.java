package com.dsi3.API.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idProducto;

    private String nombre;

    private String descripcion;

    private Double precio;

    private String categoria;


    private boolean disponible;
}
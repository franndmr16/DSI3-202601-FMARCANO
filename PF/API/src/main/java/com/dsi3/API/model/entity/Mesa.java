package com.dsi3.API.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mesa")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMesa;

    private Integer numeroMesa;
    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    private EstadoMesa estado;

    public enum EstadoMesa {
        LIBRE,
        OCUPADA
    }
}
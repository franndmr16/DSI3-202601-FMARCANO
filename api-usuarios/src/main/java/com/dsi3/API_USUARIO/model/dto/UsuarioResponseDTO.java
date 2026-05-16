package com.dsi3.API_USUARIO.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String email;
    private int edad;
}
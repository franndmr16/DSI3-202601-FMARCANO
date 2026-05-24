package com.dsi3.API.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {
    private Long idUsuario;
    private String nombre;
    private String username;
    private String password;
    private String rol;
}
package com.dsi3.API_USUARIO.mapper;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import com.dsi3.API_USUARIO.model.entity.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        return Usuario.builder()
            .nombre(dto.getNombre())
            .email(dto.getEmail())
            .edad(dto.getEdad())
            .password(dto.getPassword())
            .build();
    }

    public UsuarioResponseDTO toDTO(Usuario model) {
        return UsuarioResponseDTO.builder()
            .id(model.getId())
            .nombre(model.getNombre())
            .email(model.getEmail())
            .edad(model.getEdad())
            .build();
    }
}
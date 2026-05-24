package com.dsi3.API.mapper;

import com.dsi3.API.model.dto.UsuarioRequestDTO;
import com.dsi3.API.model.dto.UsuarioResponseDTO;
import com.dsi3.API.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        if (dto == null) return null;
        
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(dto.getIdUsuario());
        usuario.setNombre(dto.getNombre());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(dto.getRol());
        return usuario;
    }

    public UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        if (usuario == null) return null;
        
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setUsername(usuario.getUsername());
        dto.setRol(usuario.getRol());
        return dto;
    }
}
package com.dsi3.API.service.interfaces;

import com.dsi3.API.model.dto.UsuarioRequestDTO;
import com.dsi3.API.model.dto.UsuarioResponseDTO;
import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDTO> listarTodos();

    UsuarioResponseDTO buscarPorId(Long id);

    UsuarioResponseDTO crearUsuario(UsuarioRequestDTO usuarioRequestDTO);

    UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO);
    
    void eliminarUsuario(Long id);

    UsuarioResponseDTO login(String username, String password);
}
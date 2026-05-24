package com.dsi3.API.controller.interfaces;

import com.dsi3.API.model.dto.UsuarioRequestDTO;
import com.dsi3.API.model.dto.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IUsuarioController {

    ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios();

    ResponseEntity<UsuarioResponseDTO> obtenerUsuarioPorId(Long id);

    ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO usuarioDTO);

    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(Long id, UsuarioRequestDTO usuarioDTO);

    ResponseEntity<Void> eliminarUsuario(Long id);
    
    ResponseEntity<?> login(UsuarioRequestDTO loginRequest);
}
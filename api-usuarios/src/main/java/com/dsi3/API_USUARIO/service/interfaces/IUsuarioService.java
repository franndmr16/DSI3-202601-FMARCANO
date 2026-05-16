package com.dsi3.API_USUARIO.service.interfaces;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUsuarioService {
    ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request);
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();
    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(UsuarioRequestDTO request);
    ResponseEntity<String> eliminarUsuario(long id);
    ResponseEntity<String> obtenerUsuarioPorId(long id);
    ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request);
}
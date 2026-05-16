package com.dsi3.API_USUARIO.controller.interfaces;

import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/usuarios")
public interface IUsuarioController {
    @PostMapping()
    ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request);
    
    @GetMapping()
    ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios();

    @PutMapping
    ResponseEntity<UsuarioResponseDTO> actualizarUsuario(@RequestBody UsuarioRequestDTO request);

    @DeleteMapping("/{id}")
    ResponseEntity<String> eliminarUsuario(@PathVariable long id);

    @GetMapping("/{id}")
    ResponseEntity<String> obtenerUsuarioPorId(@PathVariable long id);

    @PostMapping("/session")
    ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO request);

}
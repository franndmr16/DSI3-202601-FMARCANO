package com.dsi3.API_USUARIO.controller.implementation;

import com.dsi3.API_USUARIO.controller.interfaces.IUsuarioController;
import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import com.dsi3.API_USUARIO.service.interfaces.IUsuarioService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@AllArgsConstructor
public class UsuarioController implements IUsuarioController {

    private final IUsuarioService usuarioService;

    @Override
    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(@RequestBody UsuarioRequestDTO request) {
        return usuarioService.crearUsuario(request);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @Override
    @PutMapping
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(@RequestBody UsuarioRequestDTO request) {
        return usuarioService.actualizarUsuario(request);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable long id) {
        return usuarioService.eliminarUsuario(id);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<String> obtenerUsuarioPorId(@PathVariable long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @Override
    @PostMapping("/session")
    public ResponseEntity<UsuarioResponseDTO> login(@RequestBody UsuarioRequestDTO request) {
        return usuarioService.login(request);
    }
}
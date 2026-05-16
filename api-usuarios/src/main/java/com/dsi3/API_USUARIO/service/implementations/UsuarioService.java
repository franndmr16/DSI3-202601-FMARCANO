package com.dsi3.API_USUARIO.service.implementations;

import com.dsi3.API_USUARIO.mapper.UsuarioMapper;
import com.dsi3.API_USUARIO.model.dto.UsuarioRequestDTO;
import com.dsi3.API_USUARIO.model.dto.UsuarioResponseDTO;
import com.dsi3.API_USUARIO.model.entity.Usuario;
import com.dsi3.API_USUARIO.repository.IUsuarioRepository;
import com.dsi3.API_USUARIO.service.interfaces.IUsuarioService;

import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService implements IUsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final IUsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<UsuarioResponseDTO> crearUsuario(UsuarioRequestDTO request) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(request.getEmail());

        Usuario usuario = usuarioMapper.toEntity(request);
        Usuario newUsuario = usuarioRepository.save(usuario);
        UsuarioResponseDTO response = usuarioMapper.toDTO(newUsuario);

        return ResponseEntity.status(201).body(response);
    }

    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> obtenerUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> responseUsuarios = new ArrayList<>();

        for (int i = 0; i < usuarios.size(); i++) {
            UsuarioResponseDTO response = usuarioMapper.toDTO(usuarios.get(i));
            responseUsuarios.add(response);
        }

        return ResponseEntity.ok(responseUsuarios);
    }
    @Override
    public ResponseEntity<UsuarioResponseDTO> actualizarUsuario(UsuarioRequestDTO request) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(request.getEmail());

        if (usuarioExistente.isPresent()) {
            Usuario usuario = usuarioExistente.get();
            usuario.setNombre(request.getNombre());
            usuario.setPassword(request.getPassword());
            
            Usuario usuarioActualizado = usuarioRepository.save(usuario);
            UsuarioResponseDTO response = usuarioMapper.toDTO(usuarioActualizado);
            return ResponseEntity.ok(response);
        }
        
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> eliminarUsuario(long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
        }
        return ResponseEntity.status(404).body("Usuario con ID " + id + " no encontrado.");
    }

    @Override
    public ResponseEntity<String> obtenerUsuarioPorId(long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        
        if (usuario.isPresent()) {
            return ResponseEntity.ok("Usuario encontrado: " + usuario.get().getNombre() + " (" + usuario.get().getEmail() + ")");
        }
        
        return ResponseEntity.status(404).body("Usuario con ID " + id + " no encontrado.");
    }

    @Override
    public ResponseEntity<UsuarioResponseDTO> login(UsuarioRequestDTO request) {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(request.getEmail());
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.getPassword())) {
            UsuarioResponseDTO response = usuarioMapper.toDTO(usuario.get());
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).build();
    }
}
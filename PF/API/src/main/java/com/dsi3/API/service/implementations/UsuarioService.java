package com.dsi3.API.service.implementations;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.dsi3.API.mapper.UsuarioMapper;
import com.dsi3.API.model.dto.UsuarioRequestDTO;
import com.dsi3.API.model.dto.UsuarioResponseDTO;
import com.dsi3.API.model.entity.Usuario;
import com.dsi3.API.repository.UsuarioRepository;
import com.dsi3.API.service.interfaces.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(usuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @Override
    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
    
        if (usuario.getUsername() == null && dto.getUsername() != null) {
            usuario.setUsername(dto.getUsername());
        }

        if (usuario.getPassword() != null && !usuario.getPassword().trim().isEmpty()) {
            String passwordEncriptada = DigestUtils.md5DigestAsHex(
                usuario.getPassword().getBytes(StandardCharsets.UTF_8)
            );
            usuario.setPassword(passwordEncriptada);
        }
        if (usuario.getRol() == null) {
            usuario.setRol("USER");
        }
        
        return usuarioMapper.toResponseDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(dto.getNombre());
            usuarioExistente.setUsername(dto.getUsername());
            
            if (dto.getPassword() != null && !dto.getPassword().trim().isEmpty()) {
                String passwordEncriptada = DigestUtils.md5DigestAsHex(
                    dto.getPassword().getBytes(StandardCharsets.UTF_8)
                );
                usuarioExistente.setPassword(passwordEncriptada);
            }
            
            usuarioExistente.setRol(dto.getRol());
            return usuarioMapper.toResponseDTO(usuarioRepository.save(usuarioExistente));
        }
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioResponseDTO login(String username, String password) {
        if (username == null || password == null) {
            return null;
        }
        String passwordEncriptada = DigestUtils.md5DigestAsHex(
            password.getBytes(StandardCharsets.UTF_8)
        );
        
        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, passwordEncriptada);
        return usuarioMapper.toResponseDTO(usuario);
    }
}
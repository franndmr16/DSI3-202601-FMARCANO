package com.dsi3.API.service.implementations;

import com.dsi3.API.model.entity.Usuario;
import com.dsi3.API.model.dto.UsuarioRequestDTO;
import com.dsi3.API.model.dto.UsuarioResponseDTO;
import com.dsi3.API.repository.UsuarioRepository;
import com.dsi3.API.mapper.UsuarioMapper;
import com.dsi3.API.service.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        
        return usuarioMapper.toResponseDTO(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponseDTO actualizarUsuario(Long id, UsuarioRequestDTO dto) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(dto.getNombre());
            usuarioExistente.setUsername(dto.getUsername());
            if (dto.getPassword() != null && !dto.getPassword().trim().isEmpty()) {
                usuarioExistente.setPassword(dto.getPassword());
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
        Usuario usuario = usuarioRepository.findByUsernameAndPassword(username, password);
        return usuarioMapper.toResponseDTO(usuario);
    }
}
package com.dsi3.API.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi3.API.model.dto.MesaDTO;
import com.dsi3.API.model.entity.Mesa;
import com.dsi3.API.repository.MesaRepository;
import com.dsi3.API.service.interfaces.IMesaService;

@Service
public class MesaService implements IMesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<MesaDTO> listarTodas() {
    return mesaRepository.findAll().stream()
        .filter(mesa -> mesa != null)
        .map(mesa -> {
            MesaDTO dto = new MesaDTO();
            dto.setIdMesa(mesa.getIdMesa());
            dto.setNumeroMesa(mesa.getNumeroMesa());
            dto.setCapacidad(mesa.getCapacidad());
            dto.setEstado(mesa.getEstado());
            return dto;
        }).collect(Collectors.toList());
}

    @Override
    public MesaDTO buscarPorId(Long id) {
        Mesa mesa = mesaRepository.findById(id).orElse(null);
        if (mesa == null) return null;
        
        MesaDTO dto = new MesaDTO();
        dto.setIdMesa(mesa.getIdMesa());
        dto.setNumeroMesa(mesa.getNumeroMesa());
        dto.setCapacidad(mesa.getCapacidad());
        dto.setEstado(mesa.getEstado());
        return dto;
    }

    @Override
    public MesaDTO crearMesa(MesaDTO dto) {
        Mesa mesa = new Mesa();
        mesa.setNumeroMesa(dto.getNumeroMesa());
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setEstado(Mesa.EstadoMesa.LIBRE);
        
        Mesa mesaGuardada = mesaRepository.save(mesa);
        dto.setIdMesa(mesaGuardada.getIdMesa());
        dto.setEstado(mesaGuardada.getEstado());
        return dto;
    }

    @Override
    public MesaDTO actualizarMesa(Long id, MesaDTO dto) {
        Mesa mesaExistente = mesaRepository.findById(id).orElse(null);
        if (mesaExistente != null) {
            mesaExistente.setNumeroMesa(dto.getNumeroMesa());
            mesaExistente.setCapacidad(dto.getCapacidad());
            if (dto.getEstado() != null) {
                mesaExistente.setEstado(dto.getEstado());
            }
            Mesa mesaActualizada = mesaRepository.save(mesaExistente);
            dto.setIdMesa(mesaActualizada.getIdMesa());
            dto.setEstado(mesaActualizada.getEstado());
            return dto;
        }
        return null;
    }

    @Override
    public void eliminarMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}
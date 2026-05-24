package com.dsi3.API.mapper;

import com.dsi3.API.model.dto.MesaDTO;
import com.dsi3.API.model.entity.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public Mesa toEntity(MesaDTO dto) {
        if (dto == null) return null;
        Mesa mesa = new Mesa();
        mesa.setIdMesa(dto.getIdMesa());
        mesa.setNumeroMesa(dto.getNumeroMesa());
        mesa.setCapacidad(dto.getCapacidad());
        mesa.setEstado(dto.getEstado());
        return mesa;
    }

    public MesaDTO toDTO(Mesa mesa) {
        if (mesa == null) return null;
        MesaDTO dto = new MesaDTO();
        dto.setIdMesa(mesa.getIdMesa());
        dto.setNumeroMesa(mesa.getNumeroMesa());
        dto.setCapacidad(mesa.getCapacidad());
        dto.setEstado(mesa.getEstado());
        return dto;
    }
}
package com.dsi3.API.service.interfaces;

import com.dsi3.API.model.dto.MesaDTO;
import java.util.List;

public interface IMesaService {
    List<MesaDTO> listarTodas();

    MesaDTO buscarPorId(Long id);

    MesaDTO crearMesa(MesaDTO mesaDTO);

    MesaDTO actualizarMesa(Long id, MesaDTO mesaDTO);
    
    void eliminarMesa(Long id);
}
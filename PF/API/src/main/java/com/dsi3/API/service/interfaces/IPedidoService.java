package com.dsi3.API.service.interfaces;

import java.util.List;

import com.dsi3.API.model.dto.PedidoRequestDTO;
import com.dsi3.API.model.dto.PedidoResponseDTO;

public interface IPedidoService {
    
    List<PedidoResponseDTO> listarTodos();
    
    PedidoResponseDTO buscarPorId(Long id);
    
    PedidoResponseDTO crearPedido(PedidoRequestDTO dto);

    PedidoResponseDTO cambiarEstado(Long id, String nuevoEstado);
    
    void eliminarPedido(Long id);
}
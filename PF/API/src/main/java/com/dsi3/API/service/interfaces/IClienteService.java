package com.dsi3.API.service.interfaces;

import com.dsi3.API.model.dto.ClienteDTO;
import java.util.List;

public interface IClienteService {
    List<ClienteDTO> listarTodos();

    ClienteDTO buscarPorId(Long id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO);
    
    void eliminarCliente(Long id);
}
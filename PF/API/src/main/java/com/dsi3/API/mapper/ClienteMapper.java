package com.dsi3.API.mapper;

import com.dsi3.API.model.dto.ClienteDTO;
import com.dsi3.API.model.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;
        
        Cliente cliente = new Cliente();

        cliente.setIdCliente(dto.getIdCliente());

        cliente.setNombre(dto.getNombre());

        cliente.setCorreo(dto.getCorreo());

        cliente.setTelefono(dto.getTelefono());

        return cliente;
    }

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;
        
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }
}
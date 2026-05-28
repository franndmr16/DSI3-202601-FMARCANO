package com.dsi3.API.controller.interfaces;

import com.dsi3.API.model.entity.Cliente;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IClienteController {
    ResponseEntity<List<Cliente>> listarOBuscarClientes(String nombre);

    ResponseEntity<Cliente> obtenerClientePorId(Long id);

    ResponseEntity<Cliente> crearCliente(Cliente cliente);

    ResponseEntity<Cliente> actualizarCliente(Long id, Cliente cliente);
    
    ResponseEntity<Void> eliminarCliente(Long id);
}
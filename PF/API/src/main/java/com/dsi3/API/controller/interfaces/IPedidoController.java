package com.dsi3.API.controller.interfaces;

import com.dsi3.API.model.entity.Pedido;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IPedidoController {
    ResponseEntity<List<Pedido>> listarPedidos(String estado);

    ResponseEntity<Pedido> obtenerPedidoPorId(Long id);

    ResponseEntity<Pedido> crearPedido(Pedido pedido);

    ResponseEntity<Pedido> actualizarEstado(Long id, String nuevoEstado);

    ResponseEntity<Void> eliminarPedido(Long id);

    
}
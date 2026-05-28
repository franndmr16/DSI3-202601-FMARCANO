package com.dsi3.API.controller.implementation;

import com.dsi3.API.model.dto.PedidoRequestDTO;
import com.dsi3.API.model.dto.PedidoResponseDTO;
import com.dsi3.API.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> listarTodos(@RequestParam(required = false) String estado) {
        List<PedidoResponseDTO> pedidos = pedidoService.listarTodos();
        if (estado != null && !estado.trim().isEmpty() && !"Todos".equalsIgnoreCase(estado)) {
            pedidos = pedidos.stream()
                    .filter(p -> p.getEstado() != null && p.getEstado().toString().equalsIgnoreCase(estado))
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> obtenerPorId(@PathVariable Long id) {
        PedidoResponseDTO pedido = pedidoService.buscarPorId(id);
        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
public ResponseEntity<PedidoResponseDTO> crearPedido(@RequestBody PedidoRequestDTO dto) {
    try {
        PedidoResponseDTO nuevoPedido = pedidoService.crearPedido(dto);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    } catch (RuntimeException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

    @PutMapping("/{id}/estado")
    public ResponseEntity<PedidoResponseDTO> avanzarEstado(@PathVariable Long id) {
        try {
            PedidoResponseDTO pedidoActual = pedidoService.buscarPorId(id);
            if (pedidoActual == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            String estadoActualStr = pedidoActual.getEstado().toString();
            String siguienteEstado = "Creada";
            
            if ("Creada".equalsIgnoreCase(estadoActualStr)) {
                siguienteEstado = "En preparación";
            } else if ("En preparación".equalsIgnoreCase(estadoActualStr)) {
                siguienteEstado = "Entregada";
            }

            PedidoResponseDTO pedidoActualizado = pedidoService.cambiarEstado(id, siguienteEstado);
            return new ResponseEntity<>(pedidoActualizado, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        try {
            PedidoResponseDTO pedido = pedidoService.buscarPorId(id);
            if (pedido != null && pedido.getEstado() != null && "Creada".equalsIgnoreCase(pedido.getEstado().toString())) {
                pedidoService.eliminarPedido(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/detalles")
    public ResponseEntity<Void> agregarItemAPedido(
            @PathVariable Long id, 
            @RequestBody Map<String, Object> detallePayload) {
        try {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}/detalles/{detalleId}")
    public ResponseEntity<Void> eliminarItemDePedido(
            @PathVariable Long id, 
            @PathVariable Long detalleId) {
        try {
            PedidoResponseDTO pedido = pedidoService.buscarPorId(id);
            if (pedido != null && pedido.getEstado() != null && "Creada".equalsIgnoreCase(pedido.getEstado().toString())) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
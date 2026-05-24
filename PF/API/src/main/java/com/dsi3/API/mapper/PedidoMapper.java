package com.dsi3.API.mapper;

import com.dsi3.API.model.dto.PedidoResponseDTO;
import com.dsi3.API.model.entity.Pedido;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {

    public PedidoResponseDTO toResponseDTO(Pedido pedido) {
        if (pedido == null) return null;

        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setIdPedido(pedido.getIdPedido());
        
        if (pedido.getEstado() != null) {
            dto.setEstado(pedido.getEstado().toString());
        }
        
        if (pedido.getMesa() != null) dto.setNumeroMesa(pedido.getMesa().getNumeroMesa());
        if (pedido.getCliente() != null) dto.setNombreCliente(pedido.getCliente().getNombre());
        if (pedido.getUsuario() != null) dto.setNombreUsuario(pedido.getUsuario().getNombre());

        if (pedido.getDetalles() != null) {
            dto.setDetalles(pedido.getDetalles().stream().map(detalle -> {
                PedidoResponseDTO.DetalleResponseDTO detalleDto = new PedidoResponseDTO.DetalleResponseDTO();
                detalleDto.setIdDetallePedido(detalle.getIdDetalle()); 
                
                if (detalle.getProducto() != null) {
                    detalleDto.setNombreProducto(detalle.getProducto().getNombre());
                }
                detalleDto.setCantidad(detalle.getCantidad());
                detalleDto.setPrecioUnitario(detalle.getPrecioUnitario());
                detalleDto.setSubtotal(detalle.getSubtotal());
                return detalleDto;
            }).collect(Collectors.toList()));
        } else {
            dto.setDetalles(new ArrayList<>());
        }

        return dto;
    }
}
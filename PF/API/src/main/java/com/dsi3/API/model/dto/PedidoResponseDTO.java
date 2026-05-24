package com.dsi3.API.model.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoResponseDTO {
    private Long idPedido;
    private Integer numeroMesa;
    private String nombreCliente;
    private String nombreUsuario;
    private String estado;
    private List<DetalleResponseDTO> detalles;

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetalleResponseDTO {
        private Long idDetallePedido;
        private String nombreProducto;
        private Integer cantidad;
        private Double precioUnitario;
        private Double subtotal;
    }
}
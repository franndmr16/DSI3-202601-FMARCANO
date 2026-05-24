package com.dsi3.API.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequestDTO {
    private Long idMesa;
    private Long idCliente;
    private Long idUsuario;
    private String estado;
    private List<DetallePedidoRequestDTO> detalles;

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetallePedidoRequestDTO {
        private Long idProducto;
        private Integer cantidad;
    }
}
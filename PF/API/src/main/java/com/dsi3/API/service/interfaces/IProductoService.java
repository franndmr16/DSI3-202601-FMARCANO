package com.dsi3.API.service.interfaces;

import com.dsi3.API.model.dto.ProductoDTO;
import java.util.List;

public interface IProductoService {
    List<ProductoDTO> listarTodos();

    List<ProductoDTO> filtrarPorDisponibilidad(Boolean disponible);

    List<ProductoDTO> filtrarPorCategoriaYDisponibilidad(String categoria, Boolean disponible);

    ProductoDTO buscarPorId(Long id);

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Long id, ProductoDTO productoDTO);

    void eliminarProducto(Long id);
    
}
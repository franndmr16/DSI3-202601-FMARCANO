package com.dsi3.API.controller.interfaces;

import com.dsi3.API.model.entity.Producto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IProductoController {
    ResponseEntity<List<Producto>> listarOFiltrarProductos(String categoria, Boolean disponible);

    ResponseEntity<Producto> obtenerProductoPorId(Long id);

    ResponseEntity<Producto> crearProducto(Producto producto);

    ResponseEntity<Producto> actualizarProducto(Long id, Producto producto);
    
    ResponseEntity<Void> eliminarProducto(Long id);
}
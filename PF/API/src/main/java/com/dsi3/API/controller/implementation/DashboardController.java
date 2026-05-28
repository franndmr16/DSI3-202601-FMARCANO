package com.dsi3.API.controller.implementation;

import com.dsi3.API.service.interfaces.IProductoService;
import com.dsi3.API.service.interfaces.IMesaService;
import com.dsi3.API.service.interfaces.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IMesaService mesaService;

    @Autowired
    private IPedidoService pedidoService;

    @GetMapping("/resumen")
    public ResponseEntity<Map<String, Object>> obtenerResumen() {
        try {
            Map<String, Object> resumen = new HashMap<>();
            long totalProductosActivos = productoService.listarTodos().stream()
                    .filter(p -> p.isDisponible())
                    .count();
            
            long mesasDisponibles = mesaService.listarTodas().stream()
                    .filter(m -> m.getEstado() != null && "Disponible".equalsIgnoreCase(m.getEstado().name()))
                    .count();
        
            long pedidosActivos = pedidoService.listarTodos().stream()
                    .filter(p -> p.getEstado() != null && 
                            ("Creada".equalsIgnoreCase(p.getEstado().toString()) || 
                             "En preparación".equalsIgnoreCase(p.getEstado().toString())))
                    .count();

            long pedidosEntregadosHoy = pedidoService.listarTodos().stream()
                    .filter(p -> p.getEstado() != null && "Entregada".equalsIgnoreCase(p.getEstado().toString()))
                    .count();
            
            resumen.put("totalProductosActivos", totalProductosActivos);
            resumen.put("mesasDisponibles", mesasDisponibles);
            resumen.put("pedidosActivos", pedidosActivos);
            resumen.put("pedidosEntregadosHoy", pedidosEntregadosHoy);
            
            return new ResponseEntity<>(resumen, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
package com.dsi3.API.controller.interfaces;

import com.dsi3.API.model.entity.Mesa;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface IMesaController {
    ResponseEntity<List<Mesa>> listarMesas();
    ResponseEntity<Mesa> crearMesa(Mesa mesa);
}
package com.dsi3.API.controller.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsi3.API.model.dto.MesaDTO;
import com.dsi3.API.service.interfaces.IMesaService;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private IMesaService mesaService;

    @GetMapping
    public ResponseEntity<List<MesaDTO>> listarMesas(@RequestParam(required = false) String estado) {
        List<MesaDTO> mesas = mesaService.listarTodas();
        if (estado != null && !estado.trim().isEmpty()) {
            mesas = mesas.stream()
                    .filter(m -> m.getEstado() != null && m.getEstado().name().equalsIgnoreCase(estado))
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(mesas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> obtenerMesaPorId(@PathVariable Long id) {
        MesaDTO mesaDTO = mesaService.buscarPorId(id);
        if (mesaDTO != null) {
            return new ResponseEntity<>(mesaDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<MesaDTO> crearMesa(@RequestBody MesaDTO mesaDTO) {
        try {
            MesaDTO nuevaMesa = mesaService.crearMesa(mesaDTO);
            return new ResponseEntity<>(nuevaMesa, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MesaDTO> actualizarMesa(@PathVariable Long id, @RequestBody MesaDTO mesaDTO) {
        MesaDTO mesaActualizada = mesaService.actualizarMesa(id, mesaDTO);
        if (mesaActualizada != null) {
            return new ResponseEntity<>(mesaActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMesa(@PathVariable Long id) {
        MesaDTO mesa = mesaService.buscarPorId(id);
        if (mesa != null) {
            try {
                mesaService.eliminarMesa(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (RuntimeException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
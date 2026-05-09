package com.dsi3.Calculadora.controller.implementations;

import com.dsi3.Calculadora.model.dto.DivisaRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisaResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;
import com.dsi3.Calculadora.service.interfaces.IFinancialController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FinancialController implements IFinancialController {

    private final IDivisasService divisasService;

    @Override
    public ResponseEntity<DivisaResponseDTO> calcularDivisa(DivisaRequestDTO request) {
        return ResponseEntity.ok(divisasService.calcularDivisa(request));
    }
}
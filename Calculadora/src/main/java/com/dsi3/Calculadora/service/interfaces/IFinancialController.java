package com.dsi3.Calculadora.service.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi3.Calculadora.model.dto.DivisaRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisaResponseDTO;


@RequestMapping("/api/calculadora/financiera")


public interface IFinancialController {
@PostMapping("/divisas")
ResponseEntity<DivisaResponseDTO> calcularDivisa(@RequestBody DivisaRequestDTO request);

}

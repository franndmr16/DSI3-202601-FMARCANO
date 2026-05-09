package com.dsi3.Calculadora.service.interfaces;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;

public interface ICalculatorService {
    public CalculadoraResponseDTO operacionesBasicas(CalculadoraRequestDTO values,
        int operacion
    );
}

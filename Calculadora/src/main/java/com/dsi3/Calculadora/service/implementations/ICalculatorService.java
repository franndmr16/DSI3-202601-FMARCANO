package com.dsi3.Calculadora.service.implementations;

import org.springframework.stereotype.Service;

import com.dsi3.Calculadora.model.dto.CalculadoraRequestDTO;
import com.dsi3.Calculadora.model.dto.CalculadoraResponseDTO;


    @Service


public class ICalculatorService implements com.dsi3.Calculadora.service.interfaces.ICalculatorService {

    @Override
    public CalculadoraResponseDTO operacionesBasicas(
            CalculadoraRequestDTO values, int operacion) {

        CalculadoraResponseDTO response = new CalculadoraResponseDTO();

        switch (operacion) {

            case 1:
                response.setResult(values.getInputA() + values.getInputB());
                break;

            case 2:
                response.setResult(values.getInputA() - values.getInputB());
                break;

            case 3:
                response.setResult(values.getInputA() * values.getInputB());
                break;

            case 4:
                response.setResult(
                        values.getInputB() != 0
                                ? values.getInputA() / values.getInputB()
                                : Double.NaN
                );
                break;

            default:
                response.setResult(Double.NaN);
                break;
        }

        return response;
    }
}
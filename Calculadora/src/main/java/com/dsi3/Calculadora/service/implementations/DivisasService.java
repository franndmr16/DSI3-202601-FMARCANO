package com.dsi3.Calculadora.service.implementations;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

import com.dsi3.Calculadora.model.dto.DivisaRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisaResponseDTO;
import com.dsi3.Calculadora.service.interfaces.IDivisasService;

@Service
public class DivisasService implements IDivisasService {
    private final Map<String, Double> exchangeRates = new HashMap<>() {{
        put("USD", 1.0);
        put("EUR", 0.92);
        put("COP", 3900.0);
        put("MXN", 17.0);
    }};

    @Override
    public DivisaResponseDTO calcularDivisa(DivisaRequestDTO value) {
        DivisaResponseDTO response = new DivisaResponseDTO();
        String divisaDestino = value.getDivisa().toUpperCase();
        double valorEntrada = value.getValor();

        if (exchangeRates.containsKey(divisaDestino)) {
            double rate = exchangeRates.get(divisaDestino);
            
            response.setConversionRate(rate);
            response.setConversionValue(valorEntrada * rate);
            response.setMensaje("Cambio de divisas realizado exitosamente para: " + divisaDestino);
        } else {
            response.setConversionRate(0.0);
            response.setConversionValue(0.0);
            response.setMensaje("Error: La divisa '" + divisaDestino + "' no está soportada.");
        }

        return response;
    }

    @Override
    public DivisaResponseDTO calcularDivisa1(DivisaRequestDTO value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularDivisa1'");
    }
}
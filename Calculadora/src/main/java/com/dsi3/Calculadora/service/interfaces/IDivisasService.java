package com.dsi3.Calculadora.service.interfaces;

import com.dsi3.Calculadora.model.dto.DivisaRequestDTO;
import com.dsi3.Calculadora.model.dto.DivisaResponseDTO;


public interface IDivisasService {

    public DivisaResponseDTO calcularDivisa1(DivisaRequestDTO value);

    DivisaResponseDTO calcularDivisa(DivisaRequestDTO value);

}

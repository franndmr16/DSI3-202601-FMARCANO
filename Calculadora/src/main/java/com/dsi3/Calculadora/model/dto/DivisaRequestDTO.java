package com.dsi3.Calculadora.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DivisaRequestDTO {
    private String divisa;
    private double valor;

}

package com.example.estacionamento.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EstacionamentoSpotResponse {

    private String marca;
    
    private String modelo;
    
    private String cor;

    private String placa;
    
    private String proprietario;
    
    private String apartamento;
    
    private String bloco;
    
    private String vaga;
}

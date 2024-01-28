package com.example.estacionamento.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class EstacionamentoSpotReques {

    @NotBlank
    @Size(max = 11)
    private String cpf;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String cor;
    @NotBlank
    @Size(max = 7)
    private String placa;
    @NotBlank
    private String proprietario;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;
    @NotBlank
    private String vaga;
}

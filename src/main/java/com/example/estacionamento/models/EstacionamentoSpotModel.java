package com.example.estacionamento.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "ESTACIONAMENTO")
public class EstacionamentoSpotModel{

    @Id
    private String cpf;

    @Column(name = "marca", nullable = false, length = 40)
    private String marca;

    @Column(name = "modelo", nullable = false, length = 40)
    private String modelo;

    @Column(name = "cor", nullable = false, length = 20)
    private String cor;
    
    @Column(name = "paca", nullable = false, unique = true, length = 7)
    private String placa;

    @Column(name = "data_de_cadastro", nullable = false)
    private LocalDateTime data_de_cadastro;

    @Column(name = "responsavel", nullable = false, length = 30)
    private String proprietario;

    @Column(name = "apartamento", nullable = false)
    private String apartamento;

    @Column(name = "bloco",  nullable = false ,length = 10)
    private String bloco;

    @Column(name = "vaga", nullable =  false, length = 10)
    private String vaga;

}

package com.example.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estacionamento.models.EstacionamentoSpotModel;

@Repository
public interface EstacionamentoSpotRepository extends JpaRepository<EstacionamentoSpotModel, String> {

    boolean existsByplaca(String placa);
    boolean existsBycpf(String cpf);
} 

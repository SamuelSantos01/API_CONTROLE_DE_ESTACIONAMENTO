package com.example.estacionamento.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.estacionamento.models.EstacionamentoSpotModel;
import com.example.estacionamento.repository.EstacionamentoSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class EstacionamentoSpotService {
    
    @Autowired
    EstacionamentoSpotRepository estacionamentoSpotRepository;

    @Transactional
    public EstacionamentoSpotModel save(EstacionamentoSpotModel estacionamentoSpotModel){
        return estacionamentoSpotRepository.save(estacionamentoSpotModel);
    }

    public boolean existsByplaca(String placa){
        return estacionamentoSpotRepository.existsByplaca(placa);
    }

    public boolean existsBycpf(String cpf){
        return estacionamentoSpotRepository.existsBycpf(cpf);
    }

    public java.util.List<EstacionamentoSpotModel> getCarros(){
        return estacionamentoSpotRepository.findAll();
    }
}

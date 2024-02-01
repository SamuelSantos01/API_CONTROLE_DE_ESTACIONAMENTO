package com.example.estacionamento.service;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.DTOs.EstacionamentoSpotReques;
import com.example.estacionamento.DTOs.EstacionamentoSpotResponse;
import com.example.estacionamento.models.EstacionamentoSpotModel;
import com.example.estacionamento.repository.EstacionamentoSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class EstacionamentoSpotService {
    private final EstacionamentoSpotRepository estacionamentoSpotRepository;

    @Autowired
    public EstacionamentoSpotService(EstacionamentoSpotRepository estacionamentoSpotRepository) {
        this.estacionamentoSpotRepository = estacionamentoSpotRepository;
    }

    public List<EstacionamentoSpotModel> findAll() {
        return estacionamentoSpotRepository.findAll();
    }

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

    public EstacionamentoSpotResponse getCar(EstacionamentoSpotModel estacionamentoSpotModel){
        EstacionamentoSpotResponse estacionamentoSpotResponse = new EstacionamentoSpotResponse();

        estacionamentoSpotResponse.setMarca(estacionamentoSpotModel.getMarca());
        estacionamentoSpotResponse.setModelo(estacionamentoSpotModel.getModelo());
        estacionamentoSpotResponse.setCor(estacionamentoSpotModel.getCor());
        estacionamentoSpotResponse.setPlaca(estacionamentoSpotModel.getPlaca());
        estacionamentoSpotResponse.setProprietario(estacionamentoSpotModel.getProprietario());
        estacionamentoSpotResponse.setApartamento(estacionamentoSpotModel.getApartamento());
        estacionamentoSpotResponse.setBloco(estacionamentoSpotModel.getBloco());
        estacionamentoSpotResponse.setVaga(estacionamentoSpotModel.getVaga());

        return estacionamentoSpotResponse;
    }

    public List<EstacionamentoSpotResponse> Getcars(List<EstacionamentoSpotModel> clientes) {
    return clientes.stream().map(this::getCar).collect(Collectors.toList());
    }

    public EstacionamentoSpotModel saveModel(EstacionamentoSpotReques estacionamentoSpotReques){
        EstacionamentoSpotModel estacionamentoSpotModel = new EstacionamentoSpotModel();

        estacionamentoSpotModel.setCpf(estacionamentoSpotReques.getCpf());
        estacionamentoSpotModel.setMarca(estacionamentoSpotReques.getMarca());
        estacionamentoSpotModel.setModelo(estacionamentoSpotReques.getModelo());
        estacionamentoSpotModel.setCor(estacionamentoSpotReques.getCor());
        estacionamentoSpotModel.setPlaca(estacionamentoSpotReques.getPlaca());
        estacionamentoSpotModel.setData_de_cadastro(LocalDateTime.now(ZoneId.of("UTC")));
        estacionamentoSpotModel.setProprietario(estacionamentoSpotReques.getProprietario());
        estacionamentoSpotModel.setApartamento(estacionamentoSpotReques.getApartamento());
        estacionamentoSpotModel.setBloco(estacionamentoSpotReques.getBloco());
        estacionamentoSpotModel.setVaga(estacionamentoSpotReques.getVaga());

        return estacionamentoSpotRepository.save(estacionamentoSpotModel);
    }
    

    public void deleteById(EstacionamentoSpotModel estacionamentoSpotModel){
        estacionamentoSpotRepository.delete(estacionamentoSpotModel);
    }

    public Optional<EstacionamentoSpotModel> findById (String id){
        return estacionamentoSpotRepository.findById(id);
    }

}

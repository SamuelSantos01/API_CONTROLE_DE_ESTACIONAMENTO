package com.example.estacionamento.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.estacionamento.DTOs.EstacionamentoSpotReques;
import com.example.estacionamento.models.EstacionamentoSpotModel;
import com.example.estacionamento.service.EstacionamentoSpotService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Estacionamento")
public class EstacionamentoSpotController {

    @Autowired
    EstacionamentoSpotService estacionamentoSpotService;

    @PostMapping
    public ResponseEntity<Object> saveEstacionamentoSpot(@RequestBody @Valid EstacionamentoSpotReques estacionamentoSpotReques){

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

        return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoSpotService.save(estacionamentoSpotModel));
    }
}
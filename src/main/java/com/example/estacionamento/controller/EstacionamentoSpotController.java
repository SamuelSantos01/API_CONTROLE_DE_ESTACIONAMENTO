package com.example.estacionamento.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.estacionamento.DTOs.EstacionamentoSpotReques;
import com.example.estacionamento.DTOs.EstacionamentoSpotResponse;
import com.example.estacionamento.models.EstacionamentoSpotModel;
import com.example.estacionamento.repository.EstacionamentoSpotRepository;
import com.example.estacionamento.service.EstacionamentoSpotService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Estacionamento")
public class EstacionamentoSpotController {

    @Autowired
    EstacionamentoSpotService estacionamentoSpotService;

    @Autowired 
    EstacionamentoSpotRepository estacionamentoSpotRepository;


    @PostMapping
    public ResponseEntity<Object> saveEstacionamentoSpot(@RequestBody @Valid EstacionamentoSpotReques estacionamentoSpotReques){
        
        if(estacionamentoSpotService.existsByplaca(estacionamentoSpotReques.getPlaca())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito de placa: Placa ja cadastrada");
        }
        if(estacionamentoSpotService.existsBycpf(estacionamentoSpotReques.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito de cpf: Este cpf já está cadastro e possui um veículo");
        }
      
        return ResponseEntity.status(HttpStatus.CREATED).body(estacionamentoSpotService.saveModel(estacionamentoSpotReques));
    } 

    @GetMapping
     public ResponseEntity<List<EstacionamentoSpotResponse>> getCars(){
        List<EstacionamentoSpotModel> estacionamentoSpotModels = estacionamentoSpotService.findAll();
        List<EstacionamentoSpotResponse> estacionamentoSpotResponses = estacionamentoSpotService.Getcars(estacionamentoSpotModels);

        return ResponseEntity.status(HttpStatus.OK).body(estacionamentoSpotResponses);
     
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") String id) {
        Optional<EstacionamentoSpotModel> estacionamentoOptional = estacionamentoSpotService.findById(id);

        if (!estacionamentoOptional.isPresent()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proprietário não encontrado");
        }

        EstacionamentoSpotModel estacionamentoModel = estacionamentoOptional.get();
        EstacionamentoSpotResponse estacionamentoResponse = estacionamentoSpotService.getCar(estacionamentoModel);

     return ResponseEntity.status(HttpStatus.OK).body(estacionamentoResponse);
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") String id){
        Optional<EstacionamentoSpotModel> deleteEstacionamento = estacionamentoSpotService.findById(id);

        if(!deleteEstacionamento.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Proprietario não encontrado");
        }

        EstacionamentoSpotModel deleteEstacionamentoModel = deleteEstacionamento.get();
        estacionamentoSpotService.deleteById(deleteEstacionamentoModel);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado"); 
    }
}    
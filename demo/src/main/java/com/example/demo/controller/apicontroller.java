package com.example.demo.controller;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.controller.response.ProdottoResponse;
import com.example.demo.entity.ProdottoEntity;
import com.example.demo.services.ServiziProdotto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/CONTROLLER")
public class apicontroller {
    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private ServiziProdotto serviziProdotto;

    @PostMapping("/aggiungiProdotto")
    public ResponseEntity<ProdottoResponse> aggiungiProdotto(@RequestBody ProdottoRequest prodottoRequest){
        ProdottoResponse prodottoResponse =  modelMapper.map(prodottoRequest, ProdottoResponse.class);
        ProdottoEntity prodottoEntity =  modelMapper.map(prodottoRequest, ProdottoEntity.class);
        serviziProdotto.aggiungiProdotto(prodottoEntity);
      return  ResponseEntity.ok(prodottoResponse);
    }


}

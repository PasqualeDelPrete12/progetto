package com.example.demo.controller;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.controller.response.ProdottoResponse;
import com.example.demo.entity.ProdottoEntity;
import com.example.demo.services.ServiziProdotto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ProdottoResponse> aggiungiProdotto(@RequestBody ProdottoRequest prodottoRequest) {
        ProdottoResponse prodottoResponse = modelMapper.map(prodottoRequest, ProdottoResponse.class);
        serviziProdotto.aggiungiProdotto(prodottoRequest);
        return ResponseEntity.ok(prodottoResponse);
    }

    @PutMapping("/modificaProdotto/{idProdotto}")
    public ResponseEntity<ProdottoResponse> modificaProdotto(@RequestBody ProdottoRequest prodottoRequest, @PathVariable Long idProdotto) {
        try {
            ProdottoResponse prodottoAggiornato = serviziProdotto.modificaProdotto(prodottoRequest, idProdotto);
            return new ResponseEntity<>(prodottoAggiornato, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/recuperaProdotto/{idProdotto}")
    public ResponseEntity<ProdottoResponse> recuperaProdotto(@PathVariable Long idProdotto) throws ClassNotFoundException {
        ProdottoResponse prodottoResponse = serviziProdotto.recuperaProdotto(idProdotto);
        return ResponseEntity.ok(prodottoResponse);
    }

}

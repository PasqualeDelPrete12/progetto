package com.example.demo.services;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.controller.response.ProdottoResponse;
import com.example.demo.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiziProdotto {
    void aggiungiProdotto(ProdottoRequest prodotto);

    ProdottoResponse modificaProdotto(ProdottoRequest prodotto, Long idProdotto);

    ProdottoResponse recuperaProdotto(Long idProdotto) throws ClassNotFoundException;
}

package com.example.demo.services;

import com.example.demo.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

@Service
public interface ServiziProdotto {
    void aggiungiProdotto(com.example.demo.entity.ProdottoEntity prodotto);

     ProdottoEntity modificaProdotto(ProdottoEntity prodotto, Long idProdotto);
}

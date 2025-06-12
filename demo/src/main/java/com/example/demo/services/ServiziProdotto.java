package com.example.demo.services;

import com.example.demo.entity.ProdottoEntity;

public interface ServiziProdotto {
    void aggiungiProdotto(com.example.demo.entity.ProdottoEntity prodotto);

     ProdottoEntity modificaProdotto(ProdottoEntity prodotto, Long idProdotto);
}

package com.example.demo.services;

import com.example.demo.entity.ProdottoEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiziProdottoImpl implements ServiziProdotto {


    /**
     * @param prodotto
     */
    @Override
    public void aggiungiProdotto(ProdottoEntity prodotto) {

    }

    /**
     * @param prodotto
     * @param idProdotto
     * @return
     */
    @Override
    public ProdottoEntity modificaProdotto(ProdottoEntity prodotto, Long idProdotto) {
        return null;
    }
}

package com.example.demo.services;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.entity.ProdottoEntity;
import com.example.demo.repository.ProdottoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class ServiziProdottoImpl implements ServiziProdotto {
    ModelMapper modelMapper;

    @Autowired
    private ProdottoRepository prodottoRepository;

    /**
     * @param request
     */
    @Override
    public void aggiungiProdotto(ProdottoRequest request) {
        ProdottoEntity entity = modelMapper.map(request, ProdottoEntity.class);
        prodottoRepository.save(entity);
    }

    /**
     * @param prodotto
     * @param idProdotto
     * @return
     */
    @Override
    public ProdottoEntity modificaProdotto(ProdottoEntity prodotto, Long idProdotto) {
        Optional<ProdottoEntity> prodottoEsistenteOptional = prodottoRepository.findById(idProdotto);
            if (prodottoEsistenteOptional.isPresent()){
                ProdottoEntity prodottoEsistente = prodottoEsistenteOptional.get();
                    prodottoEsistente.setNome(prodotto.getNome());
                        prodottoEsistente.setDescrizione(prodotto.getDescrizione());
                            prodottoEsistente.setPrezzo(prodotto.getPrezzo());
                                prodottoEsistente.setDisponibile(prodotto.isDisponibile());
            }else{
                throw new RuntimeException(STR."Il prodotto\{prodotto}non è stato modificato.");
            }
        return null;
    }
}

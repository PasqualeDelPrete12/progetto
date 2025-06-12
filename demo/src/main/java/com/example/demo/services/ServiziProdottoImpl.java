package com.example.demo.services;

import com.example.demo.entity.ProdottoEntity;
import com.example.demo.repository.ProdottoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class ServiziProdottoImpl implements ServiziProdotto {

    @Autowired // Inject your ProdottoRepository
    private ProdottoRepository prodottoRepository;

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
        Optional<ProdottoEntity> prodottoEsistenteOptional = prodottoRepository.findById(idProdotto);
            if (prodottoEsistenteOptional.isPresent()){
                ProdottoEntity prodottoEsistente = prodottoEsistenteOptional.get();
                    prodottoEsistente.setNome(prodotto.getNome());
                        prodottoEsistente.setDescrizione(prodotto.getDescrizione());
                            prodottoEsistente.setPrezzo(prodotto.getPrezzo());
                                prodottoEsistente.setDisponibile(prodotto.isDisponibile());
            }else{
                throw new RuntimeException("Il prodotto"+prodotto+"non è stato modificato.");
            }
        return null;
    }
}

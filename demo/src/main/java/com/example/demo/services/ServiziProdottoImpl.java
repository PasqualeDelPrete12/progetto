package com.example.demo.services;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.controller.response.ProdottoResponse;
import com.example.demo.entity.ProdottoEntity;
import com.example.demo.repository.ProdottoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class ServiziProdottoImpl implements ServiziProdotto {

    @Autowired // Inject your ProdottoRepository
    private ProdottoRepository prodottoRepository;
    private ModelMapper modelMapper = new ModelMapper();
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
    public ProdottoResponse modificaProdotto(ProdottoRequest prodotto, Long idProdotto) {
        Optional<ProdottoEntity> prodottoEsistenteOptional = prodottoRepository.findById(idProdotto);
            ProdottoEntity prodottoEsistente;
        if (prodottoEsistenteOptional.isPresent()) {
                prodottoEsistente = prodottoEsistenteOptional.get();
                    modelMapper.map(prodotto, prodottoEsistente);
                        ProdottoEntity prodottoAggiornato = prodottoRepository.save(prodottoEsistente);
                            return modelMapper.map(prodottoAggiornato, ProdottoResponse.class);
        } else {
            throw new RuntimeException("Il prodotto" + prodotto + "non è stato modificato.");
        }
    }
}

package com.example.demo.services;

import com.example.demo.controller.request.ProdottoRequest;
import com.example.demo.controller.response.ProdottoResponse;
import com.example.demo.entity.ProdottoEntity;
import com.example.demo.repository.ProdottoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.lang.StringTemplate.STR;

public class ServiziProdottoImpl implements ServiziProdotto {

    @Autowired
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
            throw new RuntimeException(STR."Il prodotto\{prodotto}non è stato modificato.");
        }
    }

    /**
     * @param idProdotto
     * @return
     */
    @Override
    public ProdottoResponse recuperaProdotto(Long idProdotto) throws ClassNotFoundException {
        Optional<ProdottoEntity> prodottoEntity = prodottoRepository.findById(idProdotto);
        if(prodottoEntity.isPresent()){
            return modelMapper.map(prodottoEntity.get(),ProdottoResponse.class);
        }else{
            throw new ClassNotFoundException("non esiste il prodotto");
        }
    }
    /**
     * @param idProdotto
     */
    @Override
    public void eliminaProdotto(Long idProdotto){
        if (prodottoRepository.existsById(idProdotto)) {
            prodottoRepository.deleteById(idProdotto);
        } else {
            throw new RuntimeException("Prodotto con ID " + idProdotto + " non trovato.");
        }
    }
}

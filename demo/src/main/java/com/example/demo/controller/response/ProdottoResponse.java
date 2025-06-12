package com.example.demo.controller.response;

import java.math.BigDecimal;

public class ProdottoResponse {
    private Long id;
    private String nome;
    private String descrizione;
    private BigDecimal prezzo;
    private boolean disponibile;

    // Costruttori
    public ProdottoResponse() {}

    public ProdottoResponse(Long id, String nome, String descrizione, BigDecimal prezzo, boolean disponibile) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.disponibile = disponibile;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}

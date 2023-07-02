package com.med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(EnderecoRecord record) {
        this.logradouro = record.logradouro();
        this.bairro = record.bairro();
        this.cep = record.cep();
        this.cidade = record.cidade();
        this.uf = record.uf();
        this.numero = record.numero();
        this.complemento = record.complemento();
    }

    public void updateAddress(EnderecoRecord record) {
        if (record.logradouro() != null)
            this.logradouro = record.logradouro();
        if (record.bairro() != null)
            this.bairro = record.bairro();
        if (record.cep() != null)
            this.cep = record.cep();
        if (record.cidade() != null)
            this.cidade = record.cidade();
        if (record.uf() != null)
            this.uf = record.uf();
        if (record.numero() != null)
            this.numero = record.numero();
        if (record.complemento() != null)
            this.complemento = record.complemento();
    }

}

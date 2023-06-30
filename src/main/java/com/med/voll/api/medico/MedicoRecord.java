package com.med.voll.api.medico;

import com.med.voll.api.endereco.EnderecoRecord;

public record MedicoRecord(String nome, String email, String crm, Especialidade especialidade, EnderecoRecord endereco) {
}

package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;
import com.med.voll.api.endereco.EnderecoRecord;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateRecord(
        @NotNull
        Long id,
        String nome,
        String telefone,
        EnderecoRecord endereco
) {
}

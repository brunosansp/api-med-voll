package com.med.voll.api.medico;

public record MedicoResponseRecord(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoResponseRecord(Medico medico) {
        this(
            medico.getId(),
            medico.getNome(),
            medico.getEmail(),
            medico.getCrm(),
            medico.getEspecialidade()
        );
    }
}

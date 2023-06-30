package com.med.voll.api.medico;

import com.med.voll.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoRecord medicoRecord) {
        this.nome = medicoRecord.nome();
        this.email = medicoRecord.email();
        this.crm = medicoRecord.crm();
        this.especialidade = medicoRecord.especialidade();
        this.endereco = new Endereco(medicoRecord.endereco());
    }
}

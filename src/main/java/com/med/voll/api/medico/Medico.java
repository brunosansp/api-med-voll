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
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(MedicoRecord record) {
        this.status = true;
        this.nome = record.nome();
        this.email = record.email();
        this.telefone = record.telefone();
        this.crm = record.crm();
        this.especialidade = record.especialidade();
        this.endereco = new Endereco(record.endereco());
    }

    public void updateInfos(MedicoUpdateRecord record) {
        if (record.nome() != null)
            this.nome = record.nome();
        if (record.telefone() != null)
            this.telefone = record.telefone();
        if (record.endereco() != null)
            this.endereco.updateAddress(record.endereco());
    }

    public void inactivate() {
        this.status = false;
    }
}

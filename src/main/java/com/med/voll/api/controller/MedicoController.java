package com.med.voll.api.controller;

import com.med.voll.api.endereco.MedicoRepository;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRecord;
import com.med.voll.api.medico.MedicoResponseRecord;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoRecord> create(@RequestBody @Valid MedicoRecord medico) {
        Medico newMedico = medicoRepository.save(new Medico(medico));
        return new ResponseEntity(newMedico, HttpStatus.CREATED);
    }

    @GetMapping
    public Page<MedicoResponseRecord> listAll(Pageable pageable) {
        return medicoRepository.findAll(pageable).map(MedicoResponseRecord::new);
    }

}

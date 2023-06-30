package com.med.voll.api.controller;

import com.med.voll.api.endereco.MedicoRepository;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRecord;
import com.med.voll.api.medico.MedicoResponseRecord;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<MedicoResponseRecord> listAll() {
        return medicoRepository.findAll().stream().map(MedicoResponseRecord::new).toList();
    }

}

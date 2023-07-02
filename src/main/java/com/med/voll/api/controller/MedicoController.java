package com.med.voll.api.controller;

import com.med.voll.api.endereco.MedicoRepository;
import com.med.voll.api.medico.Medico;
import com.med.voll.api.medico.MedicoRecord;
import com.med.voll.api.medico.MedicoResponseRecord;
import com.med.voll.api.medico.MedicoUpdateRecord;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private MedicoRepository medicoRepository;

    public MedicoController(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<MedicoRecord> create(@RequestBody @Valid MedicoRecord record) {
        Medico newMedico = medicoRepository.save(new Medico(record));
        return new ResponseEntity(newMedico, HttpStatus.CREATED);
    }

    @GetMapping
    public Page<MedicoResponseRecord> listAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByStatusTrue(pageable).map(MedicoResponseRecord::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid MedicoUpdateRecord record) {
        Medico medico = medicoRepository.getReferenceById(record.id());
        medico.updateInfos(record);
    }

    @PatchMapping("/{id}")
    @Transactional
    public void inactivate(@PathVariable Long id) {
        Medico medico = medicoRepository.getReferenceById(id);
        medico.inactivate();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }
}

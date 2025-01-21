package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.NumeroTelefono;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.NumeriTelefonoRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numeriTelefono")
public class NumeriTelefonoController {

    @Autowired
    private NumeriTelefonoRepository numeriTelefonoRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @PostMapping
    public ResponseEntity<NumeroTelefono> createNumeroTelefono(@RequestBody NumeroTelefono numeroTelefono) {

            UtenteGenerale utente = utenteGeneraleRepository.findById(numeroTelefono.getSoggettoId())
                    .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + numeroTelefono.getSoggettoId() + " non trovato"));
            numeroTelefono.setSoggetto(utente);

        // Salva il NumeroTelefono
        NumeroTelefono savedNumeroTelefono = numeriTelefonoRepository.save(numeroTelefono);
        return ResponseEntity.ok(savedNumeroTelefono);
    }

    @GetMapping("/{id}")
    public NumeroTelefono getById(@PathVariable Integer id) {
        return numeriTelefonoRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<NumeroTelefono> getAll() {
        return numeriTelefonoRepository.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody NumeroTelefono entity) {
        NumeroTelefono existingNumeroTelefono = numeriTelefonoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("NumeroTelefono con id " + id + " non trovato"));
        existingNumeroTelefono.setNumero(entity.getNumero());

         numeriTelefonoRepository.save(existingNumeroTelefono); // Salva l'oggetto aggiornato
    }

    @DeleteMapping("/{id}")//cancellato=true
    public void delete(@PathVariable Integer id) {
        numeriTelefonoRepository.deleteById(id);
    }

}
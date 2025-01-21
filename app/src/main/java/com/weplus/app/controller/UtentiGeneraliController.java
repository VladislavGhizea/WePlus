package com.weplus.app.controller;

import com.weplus.app.entita.*;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utentiGenerali")
public class UtentiGeneraliController implements IController<UtenteGenerale, Integer>{

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Override
    public void create(@RequestBody UtenteGenerale entity) {
        utenteGeneraleRepository.save(entity);
    }

    @Override
    public UtenteGenerale getById(@PathVariable Integer id) {
        return utenteGeneraleRepository.findById(id).orElse(null);
    }

    @Override
    public List<UtenteGenerale> getAll() {
        return utenteGeneraleRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody UtenteGenerale entity) {
        UtenteGenerale existingUser = utenteGeneraleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Utente con id " + id + " non trovato"));
        existingUser.setUsername(entity.getUsername());
        existingUser.setEmail(entity.getEmail());
        existingUser.setPassword(entity.getPassword());
        existingUser.setTipo(entity.getTipo());
        existingUser.setCancellato(entity.isCancellato());
        utenteGeneraleRepository.save(existingUser); // Salva l'oggetto aggiornato
    }

    @GetMapping("/{id}/ambiti")
    public ResponseEntity<List<Ambito>> getAmbitiByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getAmbiti()); // Ottieni la lista di ambiti per quell'utente
    }

    @GetMapping("/{id}/documenti")
    public ResponseEntity<List<Documento>> getDocumentoByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getDocumenti()); // Ottieni la lista di ambiti per quell'utente
    }

    @GetMapping("/{id}/hobby")
    public ResponseEntity<List<Hobby>> getHobbyByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getHobby()); // Ottieni la lista di ambiti per quell'utente
    }

    @GetMapping("/{id}/numeriTelefono")
    public ResponseEntity<List<NumeroTelefono>> getNumeroTelefonoByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getNumeroTelefono()); // Ottieni la lista di ambiti per quell'utente
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        utenteGeneraleRepository.deleteById(id);
    }
}
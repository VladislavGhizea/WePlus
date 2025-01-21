package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.AmbitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambiti")
public class AmbitiController implements  IController<Ambito, Integer>{

    @Autowired
    private AmbitoRepository ambitoRepository;

    @Override
    public void create(@RequestBody Ambito entity) {
        ambitoRepository.save(entity);
    }

    @Override
    public Ambito getById(@PathVariable Integer id) {
        return ambitoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ambito> getAll() {
        return ambitoRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody Ambito entity) {
        Ambito existingAmbito = ambitoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Ambito con id " + id + " non trovato"));
        existingAmbito.setNome(entity.getNome());
        ambitoRepository.save(existingAmbito); // Salva l'oggetto aggiornato
    }

    @GetMapping("/{id}/utenti")
    public ResponseEntity<List<UtenteGenerale>> getUtentiByAmbito(@PathVariable Integer id) {
        Ambito ambito = ambitoRepository.findById(id).orElse(null);
        if (ambito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(ambito.getSoggetti()); // Ottieni la lista di utenti per quell'ambito
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        ambitoRepository.deleteById(id);
    }
}

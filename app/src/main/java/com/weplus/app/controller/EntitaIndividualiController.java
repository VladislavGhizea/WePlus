package com.weplus.app.controller;

import com.weplus.app.entita.*;
import com.weplus.app.repository.EntitaIndividualeRepository;
import com.weplus.app.repository.IndirizziFisicaRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entitaIndividuali")
public class EntitaIndividualiController implements IController<EntitaIndividuale, Integer>{

    @Autowired
    private EntitaIndividualeRepository entitaIndividualeRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private IndirizziFisicaRepository indirizziFisicaRepository;

    @Override
    public void create(@RequestBody EntitaIndividuale entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getUtenteGeneraleId() + " non trovato"));
        entity.setUtenteGenerale(utente);

        IndirizzoFisica indirizzoFisica = indirizziFisicaRepository.findById(entity.getIndirizzoFisicaId())
                .orElseThrow(() -> new IllegalArgumentException("Indirizzo con ID " + entity.getIndirizzoFisicaId() + " non trovato"));
        entity.setIndirizzoFisica(indirizzoFisica);

        entitaIndividualeRepository.save(entity);
    }

    @GetMapping("/{id}/sedi")
    public ResponseEntity<List<Sede>> getSedeByEntita(@PathVariable Integer id) {
        EntitaIndividuale entitaIndividuale = entitaIndividualeRepository.findById(id).orElse(null);
        if (entitaIndividuale == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entitaIndividuale.getSedi()); // Ottieni la lista di ambiti per quell'utente
    }

    @Override
    public EntitaIndividuale getById(@PathVariable Integer id) {
        return entitaIndividualeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EntitaIndividuale> getAll() {
        return entitaIndividualeRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody EntitaIndividuale entity) {
        EntitaIndividuale existingEntita = entitaIndividualeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Entità con id " + id + " non trovata"));
        existingEntita.setNome(entity.getNome());
        existingEntita.setCognome(entity.getCognome());
        existingEntita.setCf(entity.getCf());
        existingEntita.setSesso(entity.getSesso());
        existingEntita.setGenere(entity.getGenere());
        existingEntita.setComuneDiN(entity.getComuneDiN());
        existingEntita.setDataDiN(entity.getDataDiN());
        existingEntita.setPartitaIva(entity.getPartitaIva());
        existingEntita.setTipo(entity.getTipo());
        existingEntita.setRagione_sociale(entity.getRagione_sociale()); // Salva l'oggetto aggiornato

        entitaIndividualeRepository.save(existingEntita);
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        entitaIndividualeRepository.deleteById(id);
    }


}
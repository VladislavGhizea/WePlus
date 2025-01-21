package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.entita.Sede;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personeGiuridiche")
public class PersoneGiuridicheController implements IController<PersonaGiuridica, Integer>{

    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Override
    public void create(@RequestBody PersonaGiuridica entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getUtenteGeneraleId() + " non trovato"));
        entity.setUtenteGenerale(utente);

         personaGiuridicaRepository.save(entity);
    }

    @Override
    public PersonaGiuridica getById(@PathVariable Integer id) {
        return personaGiuridicaRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersonaGiuridica> getAll() {
        return personaGiuridicaRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody PersonaGiuridica entity) {
        PersonaGiuridica existingPersonaGiuridica = personaGiuridicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("PersonaGiuridica con id " + id + " non trovata"));
        existingPersonaGiuridica.setTipo(entity.getTipo());
        existingPersonaGiuridica.setPartitaIva(entity.getPartitaIva());
        existingPersonaGiuridica.setRagione_sociale(entity.getRagione_sociale());
         personaGiuridicaRepository.save(existingPersonaGiuridica); // Salva l'oggetto aggiornato
    }

    @GetMapping("/{id}/sedi")
    public ResponseEntity<List<Sede>> getSediByUtente(@PathVariable Integer id) {
        PersonaGiuridica personaGiuridica = personaGiuridicaRepository.findById(id).orElse(null);
        if (personaGiuridica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(personaGiuridica.getSede()); // Ottieni la lista di ambiti per quell'utente
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        personaGiuridicaRepository.deleteById(id);
    }
}
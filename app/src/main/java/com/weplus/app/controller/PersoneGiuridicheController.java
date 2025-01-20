package com.weplus.app.controller;

import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Permetti richieste dal frontend
@RequestMapping("/PersoneGiuridiche")
public class PersoneGiuridicheController implements IController<PersonaGiuridica, Integer>{
    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Override
    public void create(@RequestBody PersonaGiuridica entity) {
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
        existingPersonaGiuridica.setSede(entity.getSede());
         personaGiuridicaRepository.save(existingPersonaGiuridica); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        personaGiuridicaRepository.deleteById(id);
    }
}
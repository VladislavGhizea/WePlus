package com.weplus.app.controller;

import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PersoneGiuridiche")
public class PersoneGiuridicheController implements IController<PersonaGiuridica, Integer>{
    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Override
    public PersonaGiuridica create(@RequestBody PersonaGiuridica entity) {
        return personaGiuridicaRepository.save(entity);
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
    public PersonaGiuridica update(@PathVariable Integer id, @RequestBody PersonaGiuridica entity) {
        PersonaGiuridica existingPersonaGiuridica = personaGiuridicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("PersonaGiuridica con id " + id + " non trovata"));
        existingPersonaGiuridica.setTipo(entity.getTipo());
        existingPersonaGiuridica.setPartitaIva(entity.getPartitaIva());
        existingPersonaGiuridica.setRagione_sociale(entity.getRagione_sociale());
        existingPersonaGiuridica.setSede(entity.getSede());
        return personaGiuridicaRepository.save(existingPersonaGiuridica); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        personaGiuridicaRepository.deleteById(id);
    }
}
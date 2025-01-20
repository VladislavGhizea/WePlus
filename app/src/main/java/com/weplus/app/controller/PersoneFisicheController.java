package com.weplus.app.controller;

import com.weplus.app.entita.PersonaFisica;
import com.weplus.app.repository.PersonaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PersonaFisica")
public class PersoneFisicheController implements IController<PersonaFisica, Integer> {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Override
    public void create(@RequestBody PersonaFisica entity) {
         personaFisicaRepository.save(entity);
    }

    @Override
    public PersonaFisica getById(@PathVariable Integer id) {
        return personaFisicaRepository.findById(id).orElse(null);
    }

    @Override
    public List<PersonaFisica> getAll() {
        return personaFisicaRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody PersonaFisica entity) {
        PersonaFisica existingPersonaFisica = personaFisicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("PersonaFisica con id " + id + " non trovata"));
        existingPersonaFisica.setCf(entity.getCf());
        existingPersonaFisica.setCognome(entity.getCognome());
        existingPersonaFisica.setNome(entity.getNome());
        existingPersonaFisica.setDataDiN(entity.getDataDiN());
        existingPersonaFisica.setGenere(entity.getGenere());
        existingPersonaFisica.setComuneDiN(entity.getComuneDiN());
        existingPersonaFisica.setSesso(entity.getSesso());
         personaFisicaRepository.save(existingPersonaFisica); // Salva l'oggetto aggiornato
    }

    @Override
    public void delete(@PathVariable Integer id) {
        personaFisicaRepository.deleteById(id);
    }
}

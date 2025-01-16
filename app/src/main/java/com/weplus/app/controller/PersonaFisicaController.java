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
public class PersonaFisicaController implements IController<PersonaFisica, Integer> {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Override
    public PersonaFisica create(@RequestBody PersonaFisica entity) {
        return personaFisicaRepository.save(entity);
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
    public PersonaFisica update(@PathVariable Integer id, @RequestBody PersonaFisica entity) {
        if (personaFisicaRepository.existsById(id)) {
            PersonaFisica existing = getById(id);
            existing.setNome(entity.getNome());
            existing.setCognome(entity.getCognome());
            existing.setDataDiN(entity.getDataDiN());
            existing.setCf(entity.getCf());
            return personaFisicaRepository.save(existing);
        }
        return null;
    }

    @Override
    public void delete(@PathVariable Integer id) {
        personaFisicaRepository.deleteById(id);
    }
}

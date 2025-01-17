package com.weplus.app.controller;

import com.weplus.app.entita.IndiceAmbito;
import com.weplus.app.entita.chiaviComposte.PKIndiceAmbiti;
import com.weplus.app.repository.IndiceAmbitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/IndiceAmbiti")
public class IndiceAmbitiController implements IController<IndiceAmbito, Integer>{

    @Autowired
    private IndiceAmbitoRepository IndiceAmbitoRepository;

    @Override
    public IndiceAmbito create(@RequestBody IndiceAmbito entity) {
        return IndiceAmbitoRepository.save(entity);
    }

    @Override
    public IndiceAmbito getById(@PathVariable Integer id) {
        return IndiceAmbitoRepository.findById(id).orElse(null);
    }

    @Override
    public List<IndiceAmbito> getAll() {
        return IndiceAmbitoRepository.findAll();
    }

    @Override
    public IndiceAmbito update(@PathVariable Integer id, @RequestBody IndiceAmbito entity) {
        //è un indice nostro, l'utente non può modificare
       return null;
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        IndiceAmbitoRepository.deleteById(id);
    }
}
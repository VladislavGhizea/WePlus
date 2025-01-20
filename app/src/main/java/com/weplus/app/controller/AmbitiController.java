package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.repository.AmbitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AmbitiController")
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

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        ambitoRepository.deleteById(id);
    }
}

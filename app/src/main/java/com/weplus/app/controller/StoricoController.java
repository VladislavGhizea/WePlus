/*package com.weplus.app.controller;

import com.weplus.app.entita.Storico;
import com.weplus.app.repository.StoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//todo, decidere cosa fa storico

@RestController
@RequestMapping("/Storico")
public class StoricoController implements IController<Storico, Integer>{
    @Autowired
    private StoricoRepository storicoRepository;

    @Override
    public Storico create(@RequestBody Storico entity) {
        return storicoRepository.save(entity);
    }

    @Override
    public Storico getById(@PathVariable Integer id) {
        return storicoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Storico> getAll() {
        return storicoRepository.findAll();
    }

    @Override
    public Storico update(@PathVariable Integer id, @RequestBody Storico entity) {
        Storico existingStorico = storicoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Storico con id " + id + " non trovato"));
        //todo
        return storicoRepository.save(existingStorico); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        storicoRepository.deleteById(id);
    }
}*/
package com.weplus.app.controller;

import com.weplus.app.entita.Sede;
import com.weplus.app.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Sedi")
public class SediController implements IController<Sede, Integer> {

    @Autowired
    private SedeRepository sedeRepositoryy;

    @Override
    public Sede create(@RequestBody Sede entity) {
        return sedeRepositoryy.save(entity);
    }

    @Override
    public Sede getById(@PathVariable Integer id) {
        return sedeRepositoryy.findById(id).orElse(null);
    }

    @Override
    public List<Sede> getAll() {
        return sedeRepositoryy.findAll();
    }

    @Override
    public Sede update(@PathVariable Integer id, @RequestBody Sede entity) {
        Sede existingSede = sedeRepositoryy.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Sede con id " + id + " non trovata"));
        existingSede.setIndirizzo(entity.getIndirizzo());
        existingSede.setPrincipale(entity.isPrincipale());
        return sedeRepositoryy.save(existingSede); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        sedeRepositoryy.deleteById(id);
    }
}

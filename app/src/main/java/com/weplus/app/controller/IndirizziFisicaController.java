package com.weplus.app.controller;

import com.weplus.app.entita.IndirizzoFisica;
import com.weplus.app.repository.IndirizziFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/indirizziFisica")
public class IndirizziFisicaController implements IController<IndirizzoFisica, Integer>{
    @Autowired
    private IndirizziFisicaRepository indirizzoFisicaRepository;

    @Override
    public void create(@RequestBody IndirizzoFisica entity) {
       indirizzoFisicaRepository.save(entity);
    }

    @Override
    public IndirizzoFisica getById(@PathVariable Integer id) {
        return indirizzoFisicaRepository.findById(id).orElse(null);
    }

    @Override
    public List<IndirizzoFisica> getAll() {
        return indirizzoFisicaRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody IndirizzoFisica entity) {
        IndirizzoFisica existingIndirizzoFisica = indirizzoFisicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("IndirizzoFisica con id " + id + " non trovato"));
        existingIndirizzoFisica.setIndiDomicilio(entity.getIndiDomicilio());
        existingIndirizzoFisica.setIndiResidenza(entity.getIndiResidenza());
         indirizzoFisicaRepository.save(existingIndirizzoFisica); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        indirizzoFisicaRepository.deleteById(id);
    }
}
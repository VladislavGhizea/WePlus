package com.weplus.app.controller;

import com.weplus.app.entita.NumeroTelefono;
import com.weplus.app.repository.NumeriTelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/NumeriTelefono")
public class NumeriTelefonoController implements IController<NumeroTelefono, Integer>{

    @Autowired
    private NumeriTelefonoRepository numeriTelefonoRepository;

    @Override
    public NumeroTelefono create(@RequestBody NumeroTelefono entity) {
        return numeriTelefonoRepository.save(entity);
    }

    @Override
    public NumeroTelefono getById(@PathVariable Integer id) {
        return numeriTelefonoRepository.findById(id).orElse(null);
    }

    @Override
    public List<NumeroTelefono> getAll() {
        return numeriTelefonoRepository.findAll();
    }

    @Override
    public NumeroTelefono update(@PathVariable Integer id, @RequestBody NumeroTelefono entity) {
        NumeroTelefono existingNumeroTelefono = numeriTelefonoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("NumeroTelefono con id " + id + " non trovato"));
        existingNumeroTelefono.setNumero(entity.getNumero());
        return numeriTelefonoRepository.save(existingNumeroTelefono); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        numeriTelefonoRepository.deleteById(id);
    }

}
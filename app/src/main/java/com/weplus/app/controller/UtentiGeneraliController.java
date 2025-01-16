package com.weplus.app.controller;

import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/UtentiGenerali")
public class UtentiGeneraliController implements IController<UtenteGenerale, Integer>{

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Override
    public UtenteGenerale create(@RequestBody UtenteGenerale entity) {
        return utenteGeneraleRepository.save(entity);
    }

    @Override
    public UtenteGenerale getById(@PathVariable Integer id) {
        return utenteGeneraleRepository.findById(id).orElse(null);
    }

    @Override
    public List<UtenteGenerale> getAll() {
        return utenteGeneraleRepository.findAll();
    }

    @Override
    public UtenteGenerale update(@PathVariable Integer id, @RequestBody UtenteGenerale entity) {
        UtenteGenerale existingUser = utenteGeneraleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Utente con id " + id + " non trovato"));
        existingUser.setUsername(entity.getUsername());
        existingUser.setEmail(entity.getEmail());
        existingUser.setPassword(entity.getPassword());
        existingUser.setTipo(entity.getTipo());
        existingUser.setCancellato(entity.isCancellato());
        return utenteGeneraleRepository.save(existingUser); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        utenteGeneraleRepository.deleteById(id);
    }
}
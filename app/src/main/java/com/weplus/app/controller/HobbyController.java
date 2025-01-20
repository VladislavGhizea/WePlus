package com.weplus.app.controller;

import com.weplus.app.entita.Hobby;
import com.weplus.app.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Hobby")
public class HobbyController implements IController<Hobby, Integer>{

    @Autowired
    private HobbyRepository HobbyRepository;

    @Override
    public void create(@RequestBody Hobby entity) {
         HobbyRepository.save(entity);
    }

    @Override
    public Hobby getById(@PathVariable Integer id) {
        return HobbyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hobby> getAll() {
        return HobbyRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody Hobby entity) {
        Hobby existingHobby = HobbyRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Hobby con id " + id + " non trovato"));
        existingHobby.setDescrizione(entity.getDescrizione());

         HobbyRepository.save(existingHobby); // Salva l'oggetto aggiornato
    }


    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        HobbyRepository.deleteById(id);
    }
}
package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.HobbyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hobby")
public class HobbyController implements IController<Hobby, Integer>{

    @Autowired
    private HobbyRepository hobbyRepository;

    @Override
    public void create(@RequestBody Hobby entity) {
         hobbyRepository.save(entity);
    }

    @Override
    public Hobby getById(@PathVariable Integer id) {
        return hobbyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Hobby> getAll() {
        return hobbyRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody Hobby entity) {
        Hobby existingHobby = hobbyRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Hobby con id " + id + " non trovato"));
        existingHobby.setDescrizione(entity.getDescrizione());

         hobbyRepository.save(existingHobby); // Salva l'oggetto aggiornato
    }

    @GetMapping("/{id}/utenti")
    public ResponseEntity<List<UtenteGenerale>> getUtentiByHobby(@PathVariable Integer id) {
        Hobby hobby = hobbyRepository.findById(id).orElse(null);
        if (hobby == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hobby.getSoggetti()); // Ottieni la lista di utenti per quell'ambito
    }


    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        hobbyRepository.deleteById(id);
    }
}
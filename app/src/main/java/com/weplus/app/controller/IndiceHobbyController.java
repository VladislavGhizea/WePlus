package com.weplus.app.controller;

import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.HobbyRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/indiceHobby")
public class IndiceHobbyController{

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @PostMapping
    public ResponseEntity<String> associaHobbyAlUtente(@RequestBody Map<String, Integer> associazione) {
        // Recupera l'utente e l'hobby tramite i loro ID
        Integer utenteId = associazione.get("utenteId");
        Integer hobbyId = associazione.get("hobbyId");

        UtenteGenerale utente = utenteGeneraleRepository.findById(utenteId).orElse(null);
        Hobby hobby = hobbyRepository.findById(hobbyId).orElse(null);

        if (utente == null || hobby == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utente o Hobby non trovato");
        }

        // Aggiungi l'hobby alla lista degli ambiti dell'utente
        utente.getHobby().add(hobby);

        // Aggiungi l'utente alla lista degli utenti dell'hobby
        hobby.getSoggetti().add(utente);

        // Salva le modifiche nel database
        utenteGeneraleRepository.save(utente);
        hobbyRepository.save(hobby);

        return ResponseEntity.ok("Associazione effettuata con successo");
    }
}
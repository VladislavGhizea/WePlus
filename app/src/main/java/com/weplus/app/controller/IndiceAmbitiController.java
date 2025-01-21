package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.AmbitoRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/indiceAmbiti")
public class IndiceAmbitiController {

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private AmbitoRepository ambitoRepository;

    @PostMapping
    public ResponseEntity<String> associaAmbitoAlUtente(@RequestBody Map<String, Integer> associazione) {
        // Recupera l'utente e l'ambito tramite i loro ID
        Integer utenteId = associazione.get("utenteId");
        Integer ambitoId = associazione.get("ambitoId");

        UtenteGenerale utente = utenteGeneraleRepository.findById(utenteId).orElse(null);
        Ambito ambito = ambitoRepository.findById(ambitoId).orElse(null);

        if (utente == null || ambito == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utente o Ambito non trovato");
        }

        // Aggiungi l'ambito alla lista degli ambiti dell'utente
        utente.getAmbiti().add(ambito);

        // Aggiungi l'utente alla lista degli utenti dell'ambito
        ambito.getSoggetti().add(utente);

        // Salva le modifiche nel database
        utenteGeneraleRepository.save(utente);
        ambitoRepository.save(ambito);

        return ResponseEntity.ok("Associazione effettuata con successo");
    }
}
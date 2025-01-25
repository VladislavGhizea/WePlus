package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.AmbitoRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/indiceAmbiti")
@Tag(name = "Indice Ambiti", description = "Gestione delle associazioni tra utenti e ambiti")
public class IndiceAmbitiController {

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private AmbitoRepository ambitoRepository;

    @Operation(
            summary = "Associa un ambito a un utente",
            description = "Permette di associare un ambito a un utente specifico utilizzando i loro ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Associazione effettuata con successo",
                    content = @Content(mediaType = "text/plain")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Utente o Ambito non trovato",
                    content = @Content(mediaType = "text/plain")
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Associazione già esistente",
                    content = @Content(mediaType = "text/plain")
            )
    })
    @PostMapping
    public ResponseEntity<String> associaAmbitoAlUtente(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Mappa che contiene gli ID dell'utente e dell'ambito da associare",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n  \"utenteId\": 1,\n  \"ambitoId\": 1\n}"
                            )
                    )
            )
            @RequestBody Map<String, Integer> associazione) {
        // Recupera l'utente e l'ambito tramite i loro ID
        Integer utenteId = associazione.get("utenteId");
        Integer ambitoId = associazione.get("ambitoId");

        UtenteGenerale utente = utenteGeneraleRepository.findById(utenteId).orElse(null);
        Ambito ambito = ambitoRepository.findById(ambitoId).orElse(null);

        if (utente == null || ambito == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utente o Ambito non trovato");
        }

        // Verifica se l'associazione esiste già
        if (utente.getAmbiti().contains(ambito)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Associazione già esistente");
        }

        // Aggiungi l'ambito alla lista degli ambiti dell'utente
        utente.getAmbiti().add(ambito);

        // Aggiungi l'utente alla lista degli utenti dell'ambito
        ambito.getSoggetti().add(utente);

        // Salva le modifiche nel database
        utenteGeneraleRepository.save(utente);

        return ResponseEntity.ok("Associazione effettuata con successo");
    }
}
package com.weplus.app.controller;

import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.HobbyRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/indiceHobby")
@Tag(name = "Indice Hobby", description = "Gestione delle associazioni tra utenti e hobby")
public class IndiceHobbyController{

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private HobbyRepository hobbyRepository;

    @Operation(
            summary = "Associa un hobby a un utente",
            description = "Permette di associare un hobby a un utente specifico utilizzando i loro ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Associazione effettuata con successo",
                    content = @Content(mediaType = "text/plain")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Utente o Hobby non trovato",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Associazione già esistente",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))
            )
    })
    @PostMapping
    public ResponseEntity<String> associaHobbyAlUtente(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Mappa che contiene gli ID dell'utente e dell'hobby da associare",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = "{\n  \"utenteId\": 1,\n  \"hobbyId\": 1\n}"
                            )
                    )
            )@RequestBody Map<String, Integer> associazione) {
        // Recupera l'utente e l'hobby tramite i loro ID
        Integer utenteId = associazione.get("utenteId");
        Integer hobbyId = associazione.get("hobbyId");

            UtenteGenerale utente = utenteGeneraleRepository.findById(utenteId).orElse(null);
            Hobby hobby = hobbyRepository.findById(hobbyId).orElse(null);

        if (utente == null || hobby == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Utente o Hobby non trovato");
        }

        // Verifica se l'associazione esiste già
        if (utente.getHobby().contains(hobby)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Associazione già esistente");
        }

        // Aggiungi l'hobby alla lista degli ambiti dell'utente
        utente.getHobby().add(hobby);

        // Aggiungi l'utente alla lista degli utenti dell'hobby
        hobby.getSoggetti().add(utente);

        // Salva le modifiche nel database
        utenteGeneraleRepository.save(utente);

        return ResponseEntity.ok("Associazione effettuata con successo");
    }
}
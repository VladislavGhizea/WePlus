package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.AmbitoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambiti")
@Tag(name = "Ambiti", description = "Gestione degli ambiti")
public class AmbitiController implements  IController<Ambito, Integer>{

    @Autowired
    private AmbitoRepository ambitoRepository;

    @Operation(
            summary = "crea un ambito",
            description = "Permette di creare un ambito"
    )
    @Override
    public void create(@RequestBody Ambito entity) {
        ambitoRepository.save(entity);
    }

    @Operation(
            summary = "recupera un ambito specifico",
            description = "Permette di recuperare un ambito specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ambito.class)))
    })
    @Override
    public Ambito getById(@PathVariable Integer id) {
        return ambitoRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti gli ambiti",
            description = "Permette di recuperare tutti gli ambiti"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ambito.class)))
    })
    @Override
    public List<Ambito> getAll() {
        return ambitoRepository.findAll();
    }

    @Operation(
            summary = "modifica un ambito esistente",
            description = "Permette di modificare un ambito esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody Ambito entity) {
        Ambito existingAmbito = ambitoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Ambito con id " + id + " non trovato"));
        existingAmbito.setNome(entity.getNome());
        ambitoRepository.save(existingAmbito); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "recupera tutti gli utenti che fanno parte di un ambito specifico",
            description = "Permette di recuperare tutti gli utenti che fanno parte di un ambito specifico tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtenteGenerale.class)))
    })
    @GetMapping("/{id}/utenti")
    public ResponseEntity<List<UtenteGenerale>> getUtentiByAmbito(@PathVariable Integer id) {
        Ambito ambito = ambitoRepository.findById(id).orElse(null);
        if (ambito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(ambito.getSoggetti()); // Ottieni la lista di utenti per quell'ambito
    }

    @Operation(
            summary = "elimina un ambito",
            description = "Permette di eliminare un ambito tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        ambitoRepository.deleteById(id);
    }
}

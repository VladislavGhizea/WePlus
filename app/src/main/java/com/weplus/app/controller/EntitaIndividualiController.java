package com.weplus.app.controller;

import com.weplus.app.entita.*;
import com.weplus.app.repository.EntitaIndividualeRepository;
import com.weplus.app.repository.IndirizziFisicaRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
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
@RequestMapping("/entitaIndividuali")
@Tag(name = "Entità individuali", description = "Gestione delle entità individuali")
public class EntitaIndividualiController implements IController<EntitaIndividuale, Integer>{

    @Autowired
    private EntitaIndividualeRepository entitaIndividualeRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private IndirizziFisicaRepository indirizziFisicaRepository;

    @Operation(
            summary = "crea un'entità individuale",
            description = "Permette di creare un'entità individuale"
    )
    @Override
    public void create(@RequestBody EntitaIndividuale entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getUtenteGeneraleId() + " non trovato"));
        entity.setUtenteGenerale(utente);

        IndirizzoFisica indirizzo = indirizziFisicaRepository.findById(entity.getIndirizzoFisicaId())
                .orElseThrow(() -> new IllegalArgumentException("indirizzo con ID " + entity.getIndirizzoFisicaId() + " non trovato"));
        entity.setIndirizzoFisica(indirizzo);

        indirizzo.setUtenteGenerale(utente);

        entitaIndividualeRepository.save(entity);
    }

    @Operation(
            summary = "recupera tutte le sedi di un'entità individuale",
            description = "Permette di recuperare tutte le sedi di un'entità individuale tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Sede.class)))
    })
    @GetMapping("/{id}/sedi")
    public ResponseEntity<List<Sede>> getSedeByEntita(@PathVariable Integer id) {
        EntitaIndividuale entitaIndividuale = entitaIndividualeRepository.findById(id).orElse(null);
        if (entitaIndividuale == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entitaIndividuale.getSedi()); // Ottieni la lista di ambiti per quell'utente
    }

    @Operation(
            summary = "recupera un'entità individuale specifica",
            description = "Permette di recuperare un'entità individuale specifica a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntitaIndividuale.class)))
    })
    @Override
    public EntitaIndividuale getById(@PathVariable Integer id) {
        return entitaIndividualeRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutte le entità individuali",
            description = "Permette di recuperare tutte le entità individuali"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EntitaIndividuale.class)))
    })
    @Override
    public List<EntitaIndividuale> getAll() {
        return entitaIndividualeRepository.findAll();
    }

    @Operation(
            summary = "modifica un'entità individuale esistente",
            description = "Permette di modificare un'entità individuale esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody EntitaIndividuale entity) {
        EntitaIndividuale existingEntita = entitaIndividualeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Entità con id " + id + " non trovata"));
        existingEntita.setNome(entity.getNome());
        existingEntita.setCognome(entity.getCognome());
        existingEntita.setCf(entity.getCf());
        existingEntita.setSesso(entity.getSesso());
        existingEntita.setGenere(entity.getGenere());
        existingEntita.setComuneDiN(entity.getComuneDiN());
        existingEntita.setDataDiN(entity.getDataDiN());
        existingEntita.setPartitaIva(entity.getPartitaIva());
        existingEntita.setRagioneSociale(entity.getRagioneSociale()); // Salva l'oggetto aggiornato

        entitaIndividualeRepository.save(existingEntita);
    }

    @Operation(
            summary = "elimina un'entità individuale",
            description = "Permette di eliminare un'entità individuale tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        entitaIndividualeRepository.deleteById(id);
    }


}
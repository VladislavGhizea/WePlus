package com.weplus.app.controller;

import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.entita.Sede;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.PersonaGiuridicaRepository;
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
@RequestMapping("/personeGiuridiche")
@Tag(name = "Persone giuridiche", description = "Gestione delle persone giuridiche")
public class PersoneGiuridicheController implements IController<PersonaGiuridica, Integer>{

    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Operation(
            summary = "crea una persona giuridica",
            description = "Permette di creare una persona giuridica"
    )
    @Override
    public void create(@RequestBody PersonaGiuridica entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getUtenteGeneraleId() + " non trovato"));
        entity.setUtenteGenerale(utente);

         personaGiuridicaRepository.save(entity);
    }

    @Operation(
            summary = "recupera una persona giuridica specifica",
            description = "Permette di recuperare una persona giuridica specifica a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaGiuridica.class)))
    })
    @Override
    public PersonaGiuridica getById(@PathVariable Integer id) {
        return personaGiuridicaRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutte le persone giuridiche",
            description = "Permette di recuperare tutte le persone giuridiche"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaGiuridica.class)))
    })
    @Override
    public List<PersonaGiuridica> getAll() {
        return personaGiuridicaRepository.findAll();
    }

    @Operation(
            summary = "modifica una persona giuridica esistente",
            description = "Permette di modificare una persona giuridica esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody PersonaGiuridica entity) {
        PersonaGiuridica existingPersonaGiuridica = personaGiuridicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("PersonaGiuridica con id " + id + " non trovata"));
        existingPersonaGiuridica.setTipo(entity.getTipo());
        existingPersonaGiuridica.setPartitaIva(entity.getPartitaIva());
        existingPersonaGiuridica.setRagioneSociale(entity.getRagioneSociale());
         personaGiuridicaRepository.save(existingPersonaGiuridica); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "recupera tutte le sedi di una persona giuridica",
            description = "Permette di recuperare tutte le sedi di una persona giuridica tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Sede.class)))
    })
    @GetMapping("/{id}/sedi")
    public ResponseEntity<List<Sede>> getSediByUtente(@PathVariable Integer id) {
        PersonaGiuridica personaGiuridica = personaGiuridicaRepository.findById(id).orElse(null);
        if (personaGiuridica == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(personaGiuridica.getSede()); // Ottieni la lista di ambiti per quell'utente
    }

    @Operation(
            summary = "elimina una persona giuridica",
            description = "Permette di eliminare una persona giuridica tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        personaGiuridicaRepository.deleteById(id);
    }
}
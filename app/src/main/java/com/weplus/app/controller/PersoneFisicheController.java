package com.weplus.app.controller;

import com.weplus.app.entita.IndirizzoFisica;
import com.weplus.app.entita.PersonaFisica;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.IndirizziFisicaRepository;
import com.weplus.app.repository.PersonaFisicaRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personeFisiche")
@Tag(name = "Persone fisiche", description = "Gestione delle persone fisiche")
public class PersoneFisicheController implements IController<PersonaFisica, Integer> {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Autowired
    private IndirizziFisicaRepository indirizziFisicaRepository;

    @Operation(
            summary = "crea una persona fisica",
            description = "Permette di creare una persona fisica"
    )
    @Override
    public void create(@RequestBody PersonaFisica entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getUtenteGeneraleId() + " non trovato"));
        entity.setUtenteGenerale(utente);

        IndirizzoFisica indirizzoFisica = indirizziFisicaRepository.findById(entity.getUtenteGeneraleId())
                .orElseThrow(() -> new IllegalArgumentException("Indirizzo con ID " + entity.getIndirizzo() + " non trovato"));
        entity.setIndirizzo(indirizzoFisica);
        indirizzoFisica.setUtenteGenerale(utente);

        personaFisicaRepository.save(entity);
    }

    @Operation(
            summary = "recupera una persona fisica specifica",
            description = "Permette di recuperare una persona fisica specifica a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaFisica.class)))
    })
    @Override
    public PersonaFisica getById(@PathVariable Integer id) {
        return personaFisicaRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutte le persone fisiche",
            description = "Permette di recuperare tutte le persone fisiche"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaFisica.class)))
    })
    @Override
    public List<PersonaFisica> getAll() {
        return personaFisicaRepository.findAll();
    }

    @Operation(
            summary = "modifica una persona fisica esistente",
            description = "Permette di modificare una persona fisica esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody PersonaFisica entity) {
        PersonaFisica existingPersonaFisica = personaFisicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("PersonaFisica con id " + id + " non trovata"));
        existingPersonaFisica.setCf(entity.getCf());
        existingPersonaFisica.setCognome(entity.getCognome());
        existingPersonaFisica.setNome(entity.getNome());
        existingPersonaFisica.setDataDiN(entity.getDataDiN());
        existingPersonaFisica.setGenere(entity.getGenere());
        existingPersonaFisica.setComuneDiN(entity.getComuneDiN());
        existingPersonaFisica.setSesso(entity.getSesso());
         personaFisicaRepository.save(existingPersonaFisica); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "elimina una persona fisica",
            description = "Permette di eliminare una persona fisica tramite l'id inserito nel path"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        personaFisicaRepository.deleteById(id);
    }
}

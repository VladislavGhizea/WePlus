package com.weplus.app.controller;

import com.weplus.app.entita.IndirizzoFisica;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.IndirizziFisicaRepository;
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
@RequestMapping("/indirizziFisica")
@Tag(name = "Indirizzi fisici", description = "Gestione degli indirizzi fisici")
public class IndirizziFisicaController implements IController<IndirizzoFisica, Integer>{
    @Autowired
    private IndirizziFisicaRepository indirizzoFisicaRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Operation(
            summary = "crea un indirizzo fisico",
            description = "Permette di creare un indirizzo fisico"
    )
    @Override
    public void create(@RequestBody IndirizzoFisica entity) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(entity.getSoggettoId())
                .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getSoggettoId() + " non trovato"));
        entity.setUtenteGenerale(utente);
       indirizzoFisicaRepository.save(entity);
    }

    @Operation(
            summary = "recupera un indirizzo fisico specifico",
            description = "Permette di recuperare un indirizzo fisico specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IndirizzoFisica.class)))
    })
    @Override
    public IndirizzoFisica getById(@PathVariable Integer id) {
        return indirizzoFisicaRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti gli indirizzi fisici",
            description = "Permette di recuperare tutti gli indirizzi fisici"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = IndirizzoFisica.class)))
    })
    @Override
    public List<IndirizzoFisica> getAll() {
        return indirizzoFisicaRepository.findAll();
    }

    @Operation(
            summary = "modifica un indirizzo fisico esistente",
            description = "Permette di modificare un indirizzo fisico esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody IndirizzoFisica entity) {
        IndirizzoFisica existingIndirizzoFisica = indirizzoFisicaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("IndirizzoFisica con id " + id + " non trovato"));
        existingIndirizzoFisica.setIndiDomicilio(entity.getIndiDomicilio());
        existingIndirizzoFisica.setIndiResidenza(entity.getIndiResidenza());
         indirizzoFisicaRepository.save(existingIndirizzoFisica); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "elimina un indirizzo fisico",
            description = "Permette di eliminare un indirizzo fisico tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        indirizzoFisicaRepository.deleteById(id);
    }
}
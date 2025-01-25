package com.weplus.app.controller;

import com.weplus.app.entita.NumeroTelefono;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.NumeriTelefonoRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numeriTelefono")
@Tag(name = "Numeri di telefono", description = "Gestione dei numeri di telefono")
public class NumeriTelefonoController {

    @Autowired
    private NumeriTelefonoRepository numeriTelefonoRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Operation(
            summary = "crea un numero di telefono",
            description = "Permette di creare un numero di telefono"
    )
    @PostMapping
    public ResponseEntity<NumeroTelefono> createNumeroTelefono(@RequestBody NumeroTelefono numeroTelefono) {

            UtenteGenerale utente = utenteGeneraleRepository.findById(numeroTelefono.getSoggettoId())
                    .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + numeroTelefono.getSoggettoId() + " non trovato"));
            numeroTelefono.setSoggetto(utente);

        // Salva il NumeroTelefono
        NumeroTelefono savedNumeroTelefono = numeriTelefonoRepository.save(numeroTelefono);
        return ResponseEntity.ok(savedNumeroTelefono);
    }

    @Operation(
            summary = "recupera un numero di telefono specifico",
            description = "Permette di recuperare un numero di telefono specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NumeroTelefono.class)))
    })
    @GetMapping("/{id}")
    public NumeroTelefono getById(@PathVariable Integer id) {
        return numeriTelefonoRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti i numeri di telefono",
            description = "Permette di recuperare tutti i numeri di telefono"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NumeroTelefono.class)))
    })
    @GetMapping
    public List<NumeroTelefono> getAll() {
        return numeriTelefonoRepository.findAll();
    }

    @Operation(
            summary = "modifica un numero di telefono esistente",
            description = "Permette di modificare un numero di telefono esistente tramite l'id inserito nel path"
    )
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody NumeroTelefono entity) {
        NumeroTelefono existingNumeroTelefono = numeriTelefonoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("NumeroTelefono con id " + id + " non trovato"));
        existingNumeroTelefono.setNumeroUno(entity.getNumeroUno());
        existingNumeroTelefono.setNumeroDue(entity.getNumeroDue());
        existingNumeroTelefono.setNumeroTre(entity.getNumeroTre());

         numeriTelefonoRepository.save(existingNumeroTelefono); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "elimina un numero di telefono",
            description = "Permette di eliminare un numero di telefono tramite l'id inserito nel path"
    )
    @DeleteMapping("/{id}")//cancellato=true
    public void delete(@PathVariable Integer id) {
        numeriTelefonoRepository.deleteById(id);
    }

}
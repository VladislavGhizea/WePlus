package com.weplus.app.controller;

import com.weplus.app.entita.*;
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
@RequestMapping("/utentiGenerali")
@Tag(name = "Utenti Generali", description = "Gestione degli utenti generali")
public class UtentiGeneraliController implements IController<UtenteGenerale, Integer>{

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Operation(
            summary = "crea un utente generale",
            description = "Permette di creare un utente generale"
    )
    @Override
    public void create(@RequestBody UtenteGenerale entity) {
        utenteGeneraleRepository.save(entity);
    }

    @Operation(
            summary = "recupera un utente generale specifico",
            description = "Permette di recuperare un utente generale specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtenteGenerale.class)))
    })
    @Override
    public UtenteGenerale getById(@PathVariable Integer id) {
        return utenteGeneraleRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti gli utenti generali",
            description = "Permette di recuperare tutti gli utenti generali"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtenteGenerale.class)))
    })
    @Override
    public List<UtenteGenerale> getAll() {
        return utenteGeneraleRepository.findAll();
    }

    @Operation(
            summary = "modifica un utente generale esistente",
            description = "Permette di modificare un utente generale esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody UtenteGenerale entity) {
        UtenteGenerale existingUser = utenteGeneraleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Utente con id " + id + " non trovato"));
        existingUser.setUsername(entity.getUsername());
        existingUser.setEmail(entity.getEmail());
        existingUser.setPassword(entity.getPassword());
        existingUser.setTipo(entity.getTipo());
        existingUser.setCancellato(entity.isCancellato());
        utenteGeneraleRepository.save(existingUser); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "recupera tutti gli ambiti di un utente generale",
            description = "Permette di recuperare tutti gli ambiti di un utente generale tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Ambito.class)))
    })
    @GetMapping("/{id}/ambiti")
    public ResponseEntity<List<Ambito>> getAmbitiByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getAmbiti()); // Ottieni la lista di ambiti per quell'utente
    }

    @Operation(
            summary = "recupera tutti i documenti di un utente generale",
            description = "Permette di recuperare tutti i documenti di un utente generale tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Documento.class)))
    })
    @GetMapping("/{id}/documenti")
    public ResponseEntity<List<Documento>> getDocumentoByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getDocumenti()); // Ottieni la lista di ambiti per quell'utente
    }

    @Operation(
            summary = "recupera tutti gli hobby di un utente generale",
            description = "Permette di recuperare tutti gli hobby di un utente generale tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Hobby.class)))
    })
    @GetMapping("/{id}/hobby")
    public ResponseEntity<List<Hobby>> getHobbyByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getHobby()); // Ottieni la lista di hobby dell'utente
    }

    @Operation(
            summary = "recupera tutti i numeri di telefono di un utente generale",
            description = "Permette di recuperare tutti i numeri di telefono di un utente generale tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = NumeroTelefono.class)))
    })
    @GetMapping("/{id}/numeriTelefono")
    public ResponseEntity<NumeroTelefono> getNumeroTelefonoByUtente(@PathVariable Integer id) {
        UtenteGenerale utente = utenteGeneraleRepository.findById(id).orElse(null);
        if (utente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(utente.getNumeroTelefono()); // Ottieni numeri di quell'utente
    }

    @Operation(
            summary = "elimina un utente generale",
            description = "Permette di eliminare un utente generale tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        utenteGeneraleRepository.deleteById(id);
    }
}
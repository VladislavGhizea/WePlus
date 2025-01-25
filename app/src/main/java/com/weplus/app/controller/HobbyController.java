package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.HobbyRepository;
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
@RequestMapping("/hobby")
@Tag(name = "Hobby", description = "Gestione degli hobby")
public class HobbyController implements IController<Hobby, Integer>{

    @Autowired
    private HobbyRepository hobbyRepository;

    @Operation(
            summary = "crea un hobby",
            description = "Permette di creare un hobby"
    )
    @Override
    public void create(@RequestBody Hobby entity) {
         hobbyRepository.save(entity);
    }

    @Operation(
            summary = "recupera un hobby specifico",
            description = "Permette di recuperare un hobby specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Hobby.class)))
    })
    @Override
    public Hobby getById(@PathVariable Integer id) {
        return hobbyRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti gli hobby",
            description = "Permette di recuperare tutti gli hobby"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Hobby.class)))
    })
    @Override
    public List<Hobby> getAll() {
        return hobbyRepository.findAll();
    }

    @Operation(
            summary = "modifica un hobby esistente",
            description = "Permette di modificare un hobby esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody Hobby entity) {
        Hobby existingHobby = hobbyRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Hobby con id " + id + " non trovato"));
        existingHobby.setDescrizione(entity.getDescrizione());

         hobbyRepository.save(existingHobby); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "recupera tutti gli utenti che hanno un hobby specifico",
            description = "Permette di recuperare tutti gli utenti che hanno un hobby specifico tramite l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UtenteGenerale.class)))
    })
    @GetMapping("/{id}/utenti")
    public ResponseEntity<List<UtenteGenerale>> getUtentiByHobby(@PathVariable Integer id) {
        Hobby hobby = hobbyRepository.findById(id).orElse(null);
        if (hobby == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(hobby.getSoggetti()); // Ottieni la lista di utenti per quell'ambito
    }

    @Operation(
            summary = "elimina un hobby",
            description = "Permette di eliminare un hobby tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        hobbyRepository.deleteById(id);
    }
}
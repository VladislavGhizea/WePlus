package com.weplus.app.controller;

import com.weplus.app.entita.EntitaIndividuale;
import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.entita.Sede;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.EntitaIndividualeRepository;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import com.weplus.app.repository.SedeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedi")
@Tag(name = "Sedi", description = "Gestione delle sedi")
public class SediController implements IController<Sede, Integer> {

    @Autowired
    private SedeRepository sedeRepositoryy;

    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Autowired
    private EntitaIndividualeRepository entitaIndividualeRepository;

    @Operation(
            summary = "crea una sede",
            description = "Permette di creare una sede"
    )
    @Override
    public void create(@RequestBody Sede entity) {

        if (entity.getPersonaGiuridicaId() != null && entity.getEntitaIndividualeId() != null) {
            throw new IllegalArgumentException("Sede non può avere sia Persona Giuridica che Entità Individuale.");
        }

        if(entity.getEntitaIndividualeId()==null){
            PersonaGiuridica personaGiuridica = personaGiuridicaRepository.findById(entity.getPersonaGiuridicaId())
                    .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getPersonaGiuridicaId() + " non trovato"));
            entity.setPersonaGiuridica(personaGiuridica);
        } else {
            EntitaIndividuale entitaIndividuale = entitaIndividualeRepository.findById(entity.getEntitaIndividualeId())
                    .orElseThrow(() -> new IllegalArgumentException("Utente con ID " + entity.getEntitaIndividualeId() + " non trovato"));
            entity.setEntitaIndividuale(entitaIndividuale);
        }
        sedeRepositoryy.save(entity);
    }

    @Operation(
            summary = "recupera una sede specifica",
            description = "Permette di recuperare una sede specifica a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Sede.class)))
    })
    @Override
    public Sede getById(@PathVariable Integer id) {
        return sedeRepositoryy.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutte le sedi",
            description = "Permette di recuperare tutte le sedi"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Sede.class)))
    })
    @Override
    public List<Sede> getAll() {
        return sedeRepositoryy.findAll();
    }

    @Operation(
            summary = "modifica una sede esistente",
            description = "Permette di modificare una sede esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody Sede entity) {
        Sede existingSede = sedeRepositoryy.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Sede con id " + id + " non trovata"));
        existingSede.setIndirizzo(entity.getIndirizzo());
        existingSede.setPrincipale(entity.isPrincipale());
         sedeRepositoryy.save(existingSede); // Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "elimina una sede",
            description = "Permette di eliminare una sede tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {sedeRepositoryy.deleteById(id);}
}

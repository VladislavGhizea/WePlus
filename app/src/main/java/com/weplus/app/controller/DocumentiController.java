package com.weplus.app.controller;

import com.weplus.app.entita.Documento;
import com.weplus.app.entita.Hobby;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.DocumentoRepository;
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
@RequestMapping("/documenti")
@Tag(name = "Documenti", description = "Gestione dei documenti")
public class DocumentiController implements IController<Documento, Integer>{

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @Operation(
            summary = "crea un documento",
            description = "Permette di creare un documento"
    )
    @Override
    public void create(@RequestBody Documento entity) {
        if (entity.getSoggettoId() == null) {
            throw new IllegalArgumentException("Il campo 'soggettoId' non può essere null");
        }

        UtenteGenerale utenteGenerale = utenteGeneraleRepository
                .findById(entity.getSoggettoId())
                .orElseThrow(() -> new IllegalArgumentException("Soggetto con ID " + entity.getSoggettoId() + " non trovato"));

        entity.setSoggetto(utenteGenerale);
        documentoRepository.save(entity);
    }

    @Operation(
            summary = "recupera un documento specifico",
            description = "Permette di recuperare un documento specifico a cui è assegnato l'id inserito nel path"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Documento.class)))
    })
    @Override
    public Documento getById(@PathVariable Integer id) {
        return documentoRepository.findById(id).orElse(null);
    }

    @Operation(
            summary = "recupera tutti i documenti",
            description = "Permette di recuperare tutti i documenti"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Documento.class)))
    })
    @Override
    public List<Documento> getAll() {
        return documentoRepository.findAll();
    }

    @Operation(
            summary = "modifica un documento esistente",
            description = "Permette di modificare un documento esistente tramite l'id inserito nel path"
    )
    @Override
    public void update(@PathVariable Integer id, @RequestBody Documento entity) {
        Documento existingDocumento = documentoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Documento con id " + id + " non trovato"));
        existingDocumento.setTipo(entity.getTipo());
        existingDocumento.setNumero(entity.getNumero());
        existingDocumento.setScadenza(entity.getScadenza());
        existingDocumento.setEnteEmissivo(entity.getEnteEmissivo());
        existingDocumento.setDataEmissione(entity.getDataEmissione());

        documentoRepository.save(existingDocumento);// Salva l'oggetto aggiornato
    }

    @Operation(
            summary = "elimina un documento",
            description = "Permette di eliminare un documento tramite l'id inserito nel path"
    )
    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        documentoRepository.deleteById(id);
    }
}
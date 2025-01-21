package com.weplus.app.controller;

import com.weplus.app.entita.Documento;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.DocumentoRepository;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documenti")
public class DocumentiController implements IController<Documento, Integer>{

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

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


    @Override
    public Documento getById(@PathVariable Integer id) {
        return documentoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Documento> getAll() {
        return documentoRepository.findAll();
    }

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

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        documentoRepository.deleteById(id);
    }
}
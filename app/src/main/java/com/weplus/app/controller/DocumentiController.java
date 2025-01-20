package com.weplus.app.controller;

import com.weplus.app.entita.Documento;
import com.weplus.app.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Documenti")
public class DocumentiController implements IController<Documento, Integer>{

    @Autowired
    private DocumentoRepository DocumentoRepository;

    @Override
    public void create(@RequestBody Documento entity) {DocumentoRepository.save(entity);}

    @Override
    public Documento getById(@PathVariable Integer id) {
        return DocumentoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Documento> getAll() {
        return DocumentoRepository.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody Documento entity) {
        Documento existingDocumento = DocumentoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Documento con id " + id + " non trovato"));
        existingDocumento.setTipo(entity.getTipo());
        existingDocumento.setNumero(entity.getNumero());
        existingDocumento.setScadenza(entity.getScadenza());
        existingDocumento.setEnteEmissivo(entity.getEnteEmissivo());
        existingDocumento.setDataEmissione(entity.getDataEmissione());

        DocumentoRepository.save(existingDocumento);// Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        DocumentoRepository.deleteById(id);
    }
}
package com.weplus.app.controller;

import com.weplus.app.entita.EntitaIndividuale;
import com.weplus.app.repository.EntitaIndividualeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/EntitaIndividuali")
public class EntitaIndividualiController implements IController<EntitaIndividuale, Integer>{

    @Autowired
    private EntitaIndividualeRepository EntitaIndividualeRepository;

    @Override
    public EntitaIndividuale create(@RequestBody EntitaIndividuale entity) {
        return EntitaIndividualeRepository.save(entity);
    }

    @Override
    public EntitaIndividuale getById(@PathVariable Integer id) {
        return EntitaIndividualeRepository.findById(id).orElse(null);
    }

    @Override
    public List<EntitaIndividuale> getAll() {
        return EntitaIndividualeRepository.findAll();
    }

    @Override
    public EntitaIndividuale update(@PathVariable Integer id, @RequestBody EntitaIndividuale entity) {
        EntitaIndividuale existingEntita = EntitaIndividualeRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Entità con id " + id + " non trovata"));
        existingEntita.setNome(entity.getNome());
        existingEntita.setCognome(entity.getCognome());
        existingEntita.setCf(entity.getCf());
        existingEntita.setSesso(entity.getSesso());
        existingEntita.setGenere(entity.getGenere());
        existingEntita.setComuneDiN(entity.getComuneDiN());
        existingEntita.setDataDiN(entity.getDataDiN());
        existingEntita.setPartitaIva(entity.getPartitaIva());
        existingEntita.setTipo(entity.getTipo());
        existingEntita.setRagione_sociale(entity.getRagione_sociale()); // Salva l'oggetto aggiornato

        return EntitaIndividualeRepository.save(existingEntita);
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {
        EntitaIndividualeRepository.deleteById(id);
    }
}
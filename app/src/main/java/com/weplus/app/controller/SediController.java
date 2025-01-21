package com.weplus.app.controller;

import com.weplus.app.entita.EntitaIndividuale;
import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.entita.Sede;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.EntitaIndividualeRepository;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import com.weplus.app.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sedi")
public class SediController implements IController<Sede, Integer> {

    @Autowired
    private SedeRepository sedeRepositoryy;

    @Autowired
    private PersonaGiuridicaRepository personaGiuridicaRepository;

    @Autowired
    private EntitaIndividualeRepository entitaIndividualeRepository;

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

    @Override
    public Sede getById(@PathVariable Integer id) {
        return sedeRepositoryy.findById(id).orElse(null);
    }

    @Override
    public List<Sede> getAll() {
        return sedeRepositoryy.findAll();
    }

    @Override
    public void update(@PathVariable Integer id, @RequestBody Sede entity) {
        Sede existingSede = sedeRepositoryy.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Sede con id " + id + " non trovata"));
        existingSede.setIndirizzo(entity.getIndirizzo());
        existingSede.setPrincipale(entity.isPrincipale());
         sedeRepositoryy.save(existingSede); // Salva l'oggetto aggiornato
    }

    @Override //cancellato=true
    public void delete(@PathVariable Integer id) {sedeRepositoryy.deleteById(id);}
}

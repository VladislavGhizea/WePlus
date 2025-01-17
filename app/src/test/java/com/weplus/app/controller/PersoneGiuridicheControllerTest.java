package com.weplus.app.controller;

import com.weplus.app.entita.PersonaGiuridica;
import com.weplus.app.entita.Sede;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.entita.listaEnum.Tipo;
import com.weplus.app.entita.listaEnum.TipoPersGiur;
import com.weplus.app.repository.PersonaGiuridicaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PersoneGiuridicheControllerTest {

    @Mock
    private PersonaGiuridicaRepository personaGiuridicaRepository;  // Il mock del repository

    @InjectMocks
    private PersoneGiuridicheController personeGiuridicheController; // Inietta il mock nel controller

    private PersonaGiuridica peano;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inizializza i mock

        UtenteGenerale pazzo = new UtenteGenerale(1,"pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false);
        Sede casa = new Sede(1, true, "Via zio pera 69");

        peano = new PersonaGiuridica(1, pazzo, "123456789", TipoPersGiur.SpA, "ragioniamo tanto", null, casa);

        // Mock dei comportamenti
        when(personaGiuridicaRepository.existsById(1)).thenReturn(true);  // Simula che l'utente esista
        when(personaGiuridicaRepository.save(any(PersonaGiuridica.class))).thenAnswer(invocation -> invocation.getArgument(0));  // Mock del salvataggio
    }

    @Test
    void create() {
        // Simula il comportamento del repository quando viene chiamato create
        when(personaGiuridicaRepository.save(any(PersonaGiuridica.class))).thenReturn(peano);

        PersonaGiuridica created = personeGiuridicheController.create(peano);

        assertNotNull(created);
        assertEquals(peano.getTipo(), created.getTipo());
        assertEquals(peano.getSede(), created.getSede());
        assertEquals(peano.getPartitaIva(), created.getPartitaIva());
        assertEquals(peano.getRagione_sociale(), created.getRagione_sociale());
        assertEquals(peano.getUtenteGenerale(), created.getUtenteGenerale());

        // Verifica che il repository save sia stato chiamato una volta
        verify(personaGiuridicaRepository, times(1)).save(any(PersonaGiuridica.class));
    }

    @Test
    void getById() {
        // Simula il comportamento del repository per il metodo getById
        when(personaGiuridicaRepository.findById(1)).thenReturn(java.util.Optional.of(peano));

         PersonaGiuridica azienda = personeGiuridicheController.getById(1);

        assertNotNull(azienda);
        assertEquals(peano.getTipo(), azienda.getTipo());
        assertEquals(peano.getSede(), azienda.getSede());
        assertEquals(peano.getPartitaIva(), azienda.getPartitaIva());
        assertEquals(peano.getRagione_sociale(), azienda.getRagione_sociale());
        assertEquals(peano.getUtenteGenerale(), azienda.getUtenteGenerale());

    }

    @Test
    void getAll() {
        // Simula il comportamento del repository per getAll
        when(personaGiuridicaRepository.findAll()).thenReturn(List.of(peano));

        List<PersonaGiuridica> personeGiuridiche = personeGiuridicheController.getAll();

        assertNotNull(personeGiuridiche);
        assertFalse(personeGiuridiche.isEmpty());
        assertEquals(peano.getTipo(), personeGiuridiche.get(0).getTipo());
        assertEquals(peano.getSede(), personeGiuridiche.get(0).getSede());
        assertEquals(peano.getPartitaIva(), personeGiuridiche.get(0).getPartitaIva());
        assertEquals(peano.getRagione_sociale(), personeGiuridiche.get(0).getRagione_sociale());
        assertEquals(peano.getUtenteGenerale(), personeGiuridiche.get(0).getUtenteGenerale());

        // Verifica che il repository findAll sia stato chiamato una volta
        verify(personaGiuridicaRepository, times(1)).findAll();
    }

    @Test
    void update() {
        // aggiornato
        UtenteGenerale pazzo = new UtenteGenerale(1,"pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false);
        Sede casa = new Sede(1, true, "Via zio pera 69");

        PersonaGiuridica grassi = new PersonaGiuridica(1, pazzo, "987654321", TipoPersGiur.SrL, "ragioniamo poco", null, casa);

        // Simula il comportamento del repository
        when(personaGiuridicaRepository.findById(1)).thenReturn(Optional.of(peano));
        when(personaGiuridicaRepository.save(any(PersonaGiuridica.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Esegui l'update
        PersonaGiuridica personaGiuridica = personeGiuridicheController.update(1, grassi);

        // Verifica che l'utente non sia null
        assertNotNull(personaGiuridica, "La persona giuridica aggiornata non deve essere null");

        // Verifica che i campi siano stati aggiornati
        assertEquals(personaGiuridica.getTipo(), grassi.getTipo());
        assertEquals(personaGiuridica.getSede(), grassi.getSede());
        assertEquals(personaGiuridica.getPartitaIva(), grassi.getPartitaIva());
        assertEquals(personaGiuridica.getRagione_sociale(), grassi.getRagione_sociale());

        // Verifica che il repository save sia stato chiamato una volta
        verify(personaGiuridicaRepository, times(1)).save(any(PersonaGiuridica.class));
    }

    @Test
    void delete() {
        // Simula il comportamento del repository per delete
        doNothing().when(personaGiuridicaRepository).deleteById(1);

        personeGiuridicheController.delete(1);

        // Verifica che il repository deleteById sia stato chiamato una volta
        verify(personaGiuridicaRepository, times(1)).deleteById(1);
    }

}
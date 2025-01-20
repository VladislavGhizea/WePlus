package com.weplus.app.controller;

import com.weplus.app.entita.Sede;
import com.weplus.app.repository.SedeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SediControllerTest {

    @Mock
    private SedeRepository sedeRepository;  // Il mock del repository

    @InjectMocks
    private SediController sediController; // Inietta il mock nel controller

    private Sede casa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inizializza i mock
        casa = new Sede( true, "Via zio pera 69");
                // Mock dei comportamenti
        when(sedeRepository.existsById(1)).thenReturn(true);  // Simula che l'utente esista
        when(sedeRepository.save(any(Sede.class))).thenAnswer(invocation -> invocation.getArgument(0));  // Mock del salvataggio
    }

    @Test
    void create() {
        // Simula il comportamento del repository quando viene chiamato create
        when(sedeRepository.save(any(Sede.class))).thenReturn(casa);

        Sede created = sediController.create(casa);

        assertNotNull(created);
        assertEquals(casa.getIndirizzo(), created.getIndirizzo());
        assertEquals(casa.isPrincipale(), created.isPrincipale());

        // Verifica che il repository save sia stato chiamato una volta
        verify(sedeRepository, times(1)).save(any(Sede.class));
    }

    @Test
    void getById() {
        // Simula il comportamento del repository per il metodo getById
        when(sedeRepository.findById(1)).thenReturn(java.util.Optional.of(casa));

        Sede abitazione = sediController.getById(1);

        assertNotNull(abitazione);
        assertEquals("Via zio pera 69", abitazione.getIndirizzo());

    }

    @Test
    void getAll() {
        // Simula il comportamento del repository per getAll
        when(sedeRepository.findAll()).thenReturn(List.of(casa));

        List<Sede> sedi = sediController.getAll();

        assertNotNull(sedi);
        assertFalse(sedi.isEmpty());
        assertEquals("Via zio pera 69", sedi.get(0).getIndirizzo());

        // Verifica che il repository findAll sia stato chiamato una volta
        verify(sedeRepository, times(1)).findAll();
    }

    @Test
    void update() {
        // Utente aggiornato
        Sede casaNuova = new Sede( false, "Via Cigna 70");
        // Simula il comportamento del repository
        when(sedeRepository.findById(1)).thenReturn(Optional.of(casa));
        when(sedeRepository.save(any(Sede.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Esegui l'update
        Sede sede = sediController.update(1, casaNuova);

        // Verifica che l'utente non sia null
        assertNotNull(sede, "La sede aggiornata non deve essere null");

        // Verifica che i campi siano stati aggiornati
        assertEquals(casa.getIndirizzo(), casaNuova.getIndirizzo());
        assertEquals(casa.isPrincipale(), casaNuova.isPrincipale());
        assertFalse(sede.isPrincipale());

        // Verifica che il repository save sia stato chiamato una volta
        verify(sedeRepository, times(1)).save(any(Sede.class));
    }

    @Test
    void delete() {
        // Simula il comportamento del repository per delete
        doNothing().when(sedeRepository).deleteById(1);

        sediController.delete(1);

        // Verifica che il repository deleteById sia stato chiamato una volta
        verify(sedeRepository, times(1)).deleteById(1);
    }
}
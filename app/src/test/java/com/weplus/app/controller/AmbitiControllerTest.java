/*package com.weplus.app.controller;

import com.weplus.app.entita.Ambito;
import com.weplus.app.repository.AmbitoRepository;
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

class AmbitiControllerTest {

    @Mock
    private AmbitoRepository AmbitoRepository;  // Il mock del repository

    @InjectMocks
    private AmbitiController ambitoController; // Inietta il mock nel controller

    private Ambito ambito;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inizializza i mock
        ambito = new Ambito ("Idraulico");
        // Mock dei comportamenti
        when(AmbitoRepository.existsById(1)).thenReturn(true);  // Simula che l'ambito esista
        when(AmbitoRepository.save(any(Ambito.class))).thenAnswer(invocation -> invocation.getArgument(0));  // Mock del salvataggio
    }

    @Test
    void create() {
        // Simula il comportamento del repository quando viene chiamato create
        when(AmbitoRepository.save(any(Ambito.class))).thenReturn(ambito);

        Ambito created = ambitoController.create(ambito);

        assertNotNull(created);
        assertEquals(ambito.getId_ambito(), created.getId_ambito());
        assertEquals(ambito.getNome(), created.getNome());

        // Verifica che il repository save sia stato chiamato una volta
        verify(AmbitoRepository, times(1)).save(any(Ambito.class));
    }

    @Test
    void getById() {
        // Simula il comportamento del repository per il metodo getById
        when(AmbitoRepository.findById(1)).thenReturn(java.util.Optional.of(ambito));

        Ambito ambito = ambitoController.getById(1);

        assertNotNull(ambito);
        assertEquals("Idraulico", ambito.getNome());

    }

    @Test
    void getAll() {
        // Simula il comportamento del repository per getAll
        when(AmbitoRepository.findAll()).thenReturn(List.of(ambito));

        List<Ambito> ambiti = ambitoController.getAll();

        assertNotNull(ambiti);
        assertFalse(ambiti.isEmpty());
        assertEquals("Idraulico", ambiti.get(0).getNome());

        // Verifica che il repository findAll sia stato chiamato una volta
        verify(AmbitoRepository, times(1)).findAll();
    }

    @Test
    void update() {
        // Utente aggiornato
        Ambito ambitoNuovo = new Ambito("Meccanico");
        // Simula il comportamento del repository
        when(AmbitoRepository.findById(1)).thenReturn(Optional.of(ambito));
        when(AmbitoRepository.save(any(Ambito.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Esegui l'update
        Ambito ambito = ambitoController.update(1, ambitoNuovo);

        // Verifica che l'utente non sia null
        assertNotNull(ambito, "Il nuovo ambito non deve essere null");

        // Verifica che i campi siano stati aggiornati
        assertEquals(ambito.getNome(), ambitoNuovo.getNome());
        assertEquals(ambito.getId_ambito(), ambitoNuovo.getId_ambito());

        // Verifica che il repository save sia stato chiamato una volta
        verify(AmbitoRepository, times(1)).save(any(Ambito.class));
    }

    @Test
    void delete() {
        // Simula il comportamento del repository per delete
        doNothing().when(AmbitoRepository).deleteById(1);

        ambitoController.delete(1);

        // Verifica che il repository deleteById sia stato chiamato una volta
        verify(AmbitoRepository, times(1)).deleteById(1);
    }
}*/
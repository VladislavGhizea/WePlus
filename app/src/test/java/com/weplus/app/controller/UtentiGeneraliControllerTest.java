/*package com.weplus.app.controller;

import com.weplus.app.entita.listaEnum.Tipo;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UtentiGeneraliControllerTest {

    @Mock
    private UtenteGeneraleRepository utenteGeneraleRepository;  // Il mock del repository

    @InjectMocks
    private UtentiGeneraliController utentiGeneraliController; // Inietta il mock nel controller

    private UtenteGenerale pazzo;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inizializza i mock
        pazzo = new UtenteGenerale("pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false);
        // Mock dei comportamenti
        when(utenteGeneraleRepository.existsById(1)).thenReturn(true);  // Simula che l'utente esista
        when(utenteGeneraleRepository.save(any(UtenteGenerale.class))).thenAnswer(invocation -> invocation.getArgument(0));  // Mock del salvataggio
    }

    @Test
    void create() {
        // Simula il comportamento del repository quando viene chiamato create
        when(utenteGeneraleRepository.save(any(UtenteGenerale.class))).thenReturn(pazzo);

        UtenteGenerale created = utentiGeneraliController.create(pazzo);

        assertNotNull(created);
        assertEquals(pazzo.getUsername(), created.getUsername());
        assertEquals(pazzo.getEmail(), created.getEmail());

        // Verifica che il repository save sia stato chiamato una volta
        verify(utenteGeneraleRepository, times(1)).save(any(UtenteGenerale.class));
    }

    @Test
    void getById() {
        // Simula il comportamento del repository per il metodo getById
        when(utenteGeneraleRepository.findById(1)).thenReturn(java.util.Optional.of(pazzo));

        UtenteGenerale user = utentiGeneraliController.getById(1);

        assertNotNull(user);
        assertEquals("pazzo", user.getUsername());

    }

    @Test
    void getAll() {
        // Simula il comportamento del repository per getAll
        when(utenteGeneraleRepository.findAll()).thenReturn(List.of(pazzo));

        List<UtenteGenerale> users = utentiGeneraliController.getAll();

        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals("pazzo", users.get(0).getUsername());

        // Verifica che il repository findAll sia stato chiamato una volta
        verify(utenteGeneraleRepository, times(1)).findAll();
    }

    @Test
    void update() {
        // Utente aggiornato
        UtenteGenerale updatedUser = new UtenteGenerale("pazzoUpdated", "updatedEmail@gmail.com", "newPassword", Tipo.FISICA, false);

        // Simula il comportamento del repository
        when(utenteGeneraleRepository.findById(1)).thenReturn(Optional.of(pazzo));
        when(utenteGeneraleRepository.save(any(UtenteGenerale.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Esegui l'update
        UtenteGenerale user = utentiGeneraliController.update(1, updatedUser);

        // Verifica che l'utente non sia null
        assertNotNull(user, "L'utente aggiornato non deve essere null");

        // Verifica che i campi siano stati aggiornati
        assertEquals("pazzoUpdated", user.getUsername());
        assertEquals("updatedEmail@gmail.com", user.getEmail());
        assertEquals("newPassword", user.getPassword());
        assertEquals(Tipo.FISICA, user.getTipo());
        assertFalse(user.isCancellato());

        // Verifica che il repository save sia stato chiamato una volta
        verify(utenteGeneraleRepository, times(1)).save(any(UtenteGenerale.class));
    }

    @Test
    void delete() {
        // Simula il comportamento del repository per delete
        doNothing().when(utenteGeneraleRepository).deleteById(1);

        utentiGeneraliController.delete(1);

        // Verifica che il repository deleteById sia stato chiamato una volta
        verify(utenteGeneraleRepository, times(1)).deleteById(1);
    }
}*/

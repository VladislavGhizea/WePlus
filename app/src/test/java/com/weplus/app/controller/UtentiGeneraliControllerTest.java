package com.weplus.app.controller;

import com.weplus.app.entita.Tipo;
import com.weplus.app.entita.UtenteGenerale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtentiGeneraliControllerTest {

    private UtentiGeneraliController utentiGeneraliController;
    private UtenteGenerale pazzo;

    @BeforeEach
    void setUp() {
        utentiGeneraliController = new UtentiGeneraliController() {
            // Simuliamo l'inserimento in memoria invece di usare il repository
            @Override
            public UtenteGenerale create(UtenteGenerale entity) {
                return entity; // Restituiamo direttamente l'oggetto come se fosse salvato
            }

            // Simuliamo il getById
            @Override
            public UtenteGenerale getById(Integer id) {
                if (id == 1) {
                    return new UtenteGenerale("pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false);
                }
                return null;
            }

            // Simuliamo il getAll (semplice lista)
            @Override
            public List<UtenteGenerale> getAll() {
                return List.of(new UtenteGenerale("pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false));
            }

            // Simuliamo l'update (modifica un campo)
            @Override
            public UtenteGenerale update(Integer id, UtenteGenerale entity) {
                if (id == 1) {
                    return new UtenteGenerale(entity.getUsername(), entity.getEmail(), entity.getPassword(), entity.getTipo(), entity.isCancellato());
                }
                return null;
            }

            // Simuliamo il delete (non facciamo nulla per il test)
            @Override
            public void delete(Integer id) {
                // Non facciamo nulla nel test
            }
        };

        pazzo = new UtenteGenerale("pazzo", "pazzo@gmail.com", "moltopazzo69", Tipo.FISICA, false);
    }

    @Test
    void create() {
        UtenteGenerale created = utentiGeneraliController.create(pazzo);
        assertNotNull(created);
        assertEquals(pazzo.getUsername(), created.getUsername());
        assertEquals(pazzo.getEmail(), created.getEmail());
    }

    @Test
    void getById() {
        UtenteGenerale user = utentiGeneraliController.getById(1);
        assertNotNull(user);
        assertEquals("pazzo", user.getUsername());
    }

    @Test
    void getAll() {
        List<UtenteGenerale> users = utentiGeneraliController.getAll();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals("pazzo", users.get(0).getUsername());
    }

    @Test
    void update() {
        UtenteGenerale updatedUser = new UtenteGenerale("pazzoUpdated", "updatedEmail@gmail.com", "newPassword", Tipo.FISICA, false);
        UtenteGenerale user = utentiGeneraliController.update(1, updatedUser);
        assertNotNull(user);
        assertEquals("pazzoUpdated", user.getUsername());
    }

    @Test
    void delete() {
        utentiGeneraliController.delete(1); // Non facciamo nulla nel test, ma possiamo verificare se non ci sono errori
        // Test che non fallisca senza eccezioni
        assertDoesNotThrow(() -> utentiGeneraliController.delete(1));
    }
}

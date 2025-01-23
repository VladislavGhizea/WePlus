package com.weplus.app.controller;

import com.weplus.app.entita.LoginRequest;
import com.weplus.app.entita.LoginResponse;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.UtenteGeneraleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UtenteGeneraleRepository utenteGeneraleRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Cerca l'utente nel database tramite username
        Optional<UtenteGenerale> utenteOpt = utenteGeneraleRepository.findByUsername(loginRequest.getUsername());

        if (utenteOpt.isPresent()) {
            UtenteGenerale utente = utenteOpt.get();

            // Restituisce la password criptata nel database (già criptata dal frontend)
            return ResponseEntity.ok(new LoginResponse(true, utente.getPassword()));
        }

        // Se username non trovato o credenziali non valide, ritorna un errore
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse(false, null));
    }

}

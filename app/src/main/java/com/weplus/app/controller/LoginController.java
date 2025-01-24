package com.weplus.app.controller;

import com.weplus.app.entita.LoginRequest;
import com.weplus.app.entita.LoginResponse;
import com.weplus.app.entita.UtenteGenerale;
import com.weplus.app.repository.UtenteGeneraleRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Login Utente", description = "Permette di effettuare il login tramite username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login effettuato con successo",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = LoginResponse.class))),
            @ApiResponse(responseCode = "401", description = "Credenziali non valide",
                    content = @Content(mediaType = "text/plain"))
    })
    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Cerca l'utente nel database tramite username
        Optional<UtenteGenerale> utenteOpt = utenteGeneraleRepository.findByUsername(loginRequest.getUsername());

        if (utenteOpt.isPresent()) {
            UtenteGenerale utente = utenteOpt.get();

            // Restituisce utente
            return ResponseEntity.ok(new LoginResponse(utente));
        }

        // Se username non trovato o credenziali non valide, ritorna un errore
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new LoginResponse(null));
    }

}

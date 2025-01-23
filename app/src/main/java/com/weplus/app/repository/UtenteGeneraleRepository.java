package com.weplus.app.repository;

import com.weplus.app.entita.UtenteGenerale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteGeneraleRepository extends JpaRepository<UtenteGenerale, Integer> {
    // aggiungere query personalizzate se necessario
    Optional<UtenteGenerale> findByUsername(String username);
}

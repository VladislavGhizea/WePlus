package com.weplus.app.repository;

import com.weplus.app.entita.UtenteGenerale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UtenteGeneraleRepository extends JpaRepository<UtenteGenerale, Integer> {
    // aggiungere query personalizzate se necessario

}

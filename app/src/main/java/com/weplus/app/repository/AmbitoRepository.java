package com.weplus.app.repository;

import com.weplus.app.entita.Ambito;
import com.weplus.app.entita.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AmbitoRepository extends JpaRepository<Ambito, Integer> {
    // aggiungere query personalizzate se necessario

}
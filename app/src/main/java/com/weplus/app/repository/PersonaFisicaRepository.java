package com.weplus.app.repository;

import com.weplus.app.entita.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Integer> {
    // aggiungere query personalizzate se necessario

}
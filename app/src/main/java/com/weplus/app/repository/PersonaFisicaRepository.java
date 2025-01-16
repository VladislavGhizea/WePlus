package com.weplus.app.repository;

import com.weplus.app.entita.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Integer> {
    // aggiungere query personalizzate se necessario

}
package com.weplus.app.repository;

import com.weplus.app.entita.Ambito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmbitoRepository extends JpaRepository<Ambito, Integer> {
    // aggiungere query personalizzate se necessario

}
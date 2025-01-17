package com.weplus.app.repository;

import com.weplus.app.entita.EntitaIndividuale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntitaIndividualeRepository extends JpaRepository<EntitaIndividuale, Integer> {
    // aggiungere query personalizzate se necessario

}
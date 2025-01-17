package com.weplus.app.repository;

import com.weplus.app.entita.EntitaIndividuale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitaIndividualeRepository extends JpaRepository<EntitaIndividuale, Integer> {
    // aggiungere query personalizzate se necessario

}
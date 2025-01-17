package com.weplus.app.repository;

import com.weplus.app.entita.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    // aggiungere query personalizzate se necessario

}

package com.weplus.app.repository;

import com.weplus.app.entita.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    // aggiungere query personalizzate se necessario

}

package com.weplus.app.repository;

import com.weplus.app.entita.Documento;
import com.weplus.app.entita.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer> {
    // aggiungere query personalizzate se necessario

}

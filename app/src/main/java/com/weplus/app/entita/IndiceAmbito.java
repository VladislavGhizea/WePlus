package com.weplus.app.entita;

import com.weplus.app.entita.chiaviComposte.PKIndiceAmbiti;
import jakarta.persistence.*;

@Entity
@Table(name = "IndiceAmbito")
public class IndiceAmbito {

    @EmbeddedId
    private PKIndiceAmbiti id; // Usa la chiave composta

    @ManyToOne
    @JoinColumn(name = "id_ambito", insertable = false, updatable = false) // Collega la chiave esterna
    private Ambito ambito;

    @ManyToOne
    @JoinColumn(name = "id_soggetto", insertable = false, updatable = false) // Collega la chiave esterna
    private UtenteGenerale soggetto;

    public IndiceAmbito() {
    }

    public IndiceAmbito(PKIndiceAmbiti id, Ambito ambito, UtenteGenerale soggetto) {
        this.id = id;
        this.ambito = ambito;
        this.soggetto = soggetto;
    }

    public IndiceAmbito(Ambito ambito, UtenteGenerale soggetto) {
        this.ambito = ambito;
        this.soggetto = soggetto;
    }

    public PKIndiceAmbiti getId() {
        return id;
    }

    public Ambito getAmbito() {
        return ambito;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }
}

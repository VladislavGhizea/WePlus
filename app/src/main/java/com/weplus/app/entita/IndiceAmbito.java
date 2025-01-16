package com.weplus.app.entita;

import com.weplus.app.entita.chiaviComposte.PKIndiceAmbiti;
import jakarta.persistence.*;
import jakarta.persistence.EmbeddedId;

@Entity
@Table(name = "IndiceAmbito")
public class IndiceAmbito {

    @EmbeddedId
    private PKIndiceAmbiti id;

    @ManyToOne
    @MapsId("idAmbito")
    @JoinColumn(name = "id_ambito")
    private Ambito ambito;

    @ManyToOne
    @MapsId("idSoggetto")
    @JoinColumn(name = "id_soggetto")
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
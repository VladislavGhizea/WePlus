package com.weplus.app.entita;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PKIndiceAmbiti implements Serializable {

    private Integer id_ambito;
    private Integer id_soggetto;

    public PKIndiceAmbiti() {}

    public PKIndiceAmbiti(Integer id_ambito, Integer id_soggetto) {
        this.id_ambito = id_ambito;
        this.id_soggetto = id_soggetto;
    }

    public Integer getId_ambito() {
        return id_ambito;
    }

    public Integer getId_soggetto() {
        return id_soggetto;
    }
}

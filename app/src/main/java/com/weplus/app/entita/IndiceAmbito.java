package com.weplus.app.entita;

import jakarta.persistence.*;
import jakarta.persistence.EmbeddedId;

@Entity
@Table(name = "IndiceAmbito")
public class IndiceAmbito {

    @ManyToMany //controllare con la key di ambiti
    @EmbeddedId
    private PKIndiceAmbiti indici;

    public IndiceAmbito() {
    }

    public IndiceAmbito(PKIndiceAmbiti indici) {
        this.indici = indici;
    }

    public PKIndiceAmbiti getIndici() {
        return indici;
    }
}
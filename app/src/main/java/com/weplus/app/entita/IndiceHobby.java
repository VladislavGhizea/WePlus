package com.weplus.app.entita;

import com.weplus.app.entita.chiaviComposte.PKIndiceHobby;
import jakarta.persistence.*;

@Entity
@Table(name = "IndiceHobby")
public class IndiceHobby {

    @EmbeddedId
    private PKIndiceHobby id;  // Chiave primaria composta

    @ManyToOne
    @JoinColumn(name = "id_hobby", insertable = false, updatable = false, nullable = false)
    private Hobby hobby;  // Relazione con Hobby

    @ManyToOne
    @JoinColumn(name = "id_soggetto", insertable = false, updatable = false, nullable = false)
    private UtenteGenerale soggetto;  // Relazione con UtenteGenerale

    // Costruttore predefinito
    public IndiceHobby() {}

    // Costruttore con oggetti relazionati
    public IndiceHobby(Hobby hobby, UtenteGenerale soggetto) {
        this.hobby = hobby;
        this.soggetto = soggetto;
    }

    // Getter e Setter
    public PKIndiceHobby getId() {
        return id;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }
}

package com.weplus.app.entita;

import com.weplus.app.entita.chiaviComposte.IndiceHobbyId;
import jakarta.persistence.*;

@Entity
@Table(name = "IndiceHobby")
public class IndiceHobby {

    @EmbeddedId
    private IndiceHobbyId id;

    @ManyToOne
    @MapsId("idHobby")
    @JoinColumn(name = "id_hobby", nullable = false)
    private Hobby hobby;

    @ManyToOne
    @MapsId("idSoggetto")
    @JoinColumn(name = "id_soggetto", nullable = false)
    private UtenteGenerale soggetto;

    // Costruttore predefinito
    public IndiceHobby() {}

    public IndiceHobby(IndiceHobbyId id, Hobby hobby, UtenteGenerale soggetto) {
        this.id = id;
        this.hobby = hobby;
        this.soggetto = soggetto;
    }

    public IndiceHobby(Hobby hobby, UtenteGenerale soggetto) {
        this.hobby = hobby;
        this.soggetto = soggetto;
    }

    // Getter e Setter
    public IndiceHobbyId getId() {
        return id;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }


}

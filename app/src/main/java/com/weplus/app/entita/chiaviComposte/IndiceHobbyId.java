package com.weplus.app.entita.chiaviComposte;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class IndiceHobbyId implements Serializable {
    private Integer id_hobby;
    private Integer id_soggetto;

    public IndiceHobbyId() {}

    public IndiceHobbyId(Integer id_hobby, Integer id_soggetto) {
        this.id_hobby = id_hobby;
        this.id_soggetto = id_soggetto;
    }

    public Integer getId_hobby() {
        return id_hobby;
    }

    public Integer getId_soggetto() {
        return id_soggetto;
    }

    //(necessari per JPA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndiceHobbyId that = (IndiceHobbyId) o;
        return id_hobby.equals(that.id_hobby) && id_soggetto.equals(that.id_soggetto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_hobby, id_soggetto);
    }
}

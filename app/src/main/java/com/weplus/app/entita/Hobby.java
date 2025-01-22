package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "hobby_id")
    private Integer hobby_id;

    @ManyToMany(mappedBy = "hobby")
    @JsonIgnore
    private List<UtenteGenerale> soggetti;

    @Column(nullable = false) // Campo obbligatorio
    private String descrizione;

    public Hobby() {

    }


    public Hobby(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getHobby_id() {
        return hobby_id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public List<UtenteGenerale> getSoggetti() {
        return soggetti;
    }
}

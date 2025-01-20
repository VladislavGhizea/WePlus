package com.weplus.app.entita;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_hobby;

    @OneToMany(mappedBy = "hobby")
    private List<IndiceHobby> indiceHobby;

    @Column(nullable = false) // Campo obbligatorio
    private String descrizione;

    public Hobby() {

    }

    public List<IndiceHobby> getIndiceHobby() {
        return indiceHobby;
    }

    public Hobby(String descrizione) {
        this.descrizione = descrizione;
    }

    public Hobby(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getId_hobby() {
        return id_hobby;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}

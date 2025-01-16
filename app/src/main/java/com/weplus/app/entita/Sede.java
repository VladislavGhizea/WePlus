package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede {

    @Id
    @OneToMany //controllare con entInidiv e persGiurid
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_sede;

    @Column(nullable = false) // Campo obbligatorio
    private String indirizzo;

    @Column(nullable = false) // Campo obbligatorio
    private boolean principale=false;

    public Sede() {}

    public Sede(Integer id_sede, boolean principale, String indirizzo) {
        this.id_sede = id_sede;
        this.principale = principale;
        this.indirizzo = indirizzo;
    }

    public Integer getId_sede() {
        return id_sede;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }
    
}

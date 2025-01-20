package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "NumeriTelefono")
public class NumeroTelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_numTel;

    @Column(nullable = false) // Campo obbligatorio
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "soggetto_id", nullable = false)
    private UtenteGenerale soggetto;

    public NumeroTelefono() {}

    public NumeroTelefono(Integer numero, UtenteGenerale soggetto) {
        this.numero = numero;
        this.soggetto = soggetto;
    }

    public Integer getId_numTel() {
        return id_numTel;
    }

    public Integer getNumero() {
        return numero;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
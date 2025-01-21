package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private UtenteGenerale soggetto;

    @Transient
    private Integer soggettoId;

    public NumeroTelefono() {}

    public NumeroTelefono(Integer numero, Integer soggettoId) {
        this.numero = numero;
        this.soggettoId = soggettoId;
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

    public Integer getSoggettoId() {
        return soggettoId;
    }

    public void setSoggetto(UtenteGenerale soggetto) {
        this.soggetto = soggetto;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
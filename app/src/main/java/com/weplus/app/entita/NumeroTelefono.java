package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "NumeriTelefono")
public class NumeroTelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "numTel_id")
    private Integer numTel_id;

    @Column(nullable = false, length = 10, unique = true) // Campo obbligatorio
    private Integer numeroUno;

    @Column(length = 10, unique = true)
    private Integer numeroDue;

    @Column(length = 10, unique = true)
    private Integer numeroTre;

    @ManyToOne
    @JoinColumn(name = "soggetto_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private UtenteGenerale soggetto;

    @Column(name = "soggetto_id", insertable = true, updatable = true, nullable = false, unique = true)
    private Integer soggettoId;

    public NumeroTelefono() {}

    public NumeroTelefono(Integer numeroUno, Integer numeroDue, Integer numeroTre, Integer soggettoId) {
        this.numeroUno = numeroUno;
        this.numeroDue = numeroDue;
        this.numeroTre = numeroTre;
        this.soggettoId = soggettoId;
    }

    public Integer getNumTel_id() {
        return numTel_id;
    }

    public Integer getNumeroUno() {
        return numeroUno;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }

    @JsonProperty("soggettoId")
    public Integer getSoggettoId() {
        return soggettoId;
    }

    public void setSoggetto(UtenteGenerale soggetto) {
        this.soggetto = soggetto;
    }

    public void setNumeroUno(Integer numeroUno) {
        this.numeroUno = numeroUno;
    }

    public Integer getNumeroDue() {
        return numeroDue;
    }

    public void setNumeroDue(Integer numeroDue) {
        this.numeroDue = numeroDue;
    }

    public Integer getNumeroTre() {
        return numeroTre;
    }

    public void setNumeroTre(Integer numeroTre) {
        this.numeroTre = numeroTre;
    }


}
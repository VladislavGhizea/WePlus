package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "NumeriTelefono")
public class NumeriTelefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_numTel;

    @Column(nullable = false) // Campo obbligatorio
    private Integer numero;

    @Id
    @OneToMany //controllare con soggetto
    @Column(nullable = false) // Campo obbligatorio
    private Integer soggetto_id;

    public NumeriTelefono() {}

    public NumeriTelefono(Integer numero, Integer soggetto_id, Integer id_numTel) {
        this.numero = numero;
        this.soggetto_id = soggetto_id;
        this.id_numTel = id_numTel;
    }

    public Integer getId_numTel() {
        return id_numTel;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getSoggetto_id() {
        return soggetto_id;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
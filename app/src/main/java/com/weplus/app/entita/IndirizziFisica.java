package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "IndirizziFisica")
public class IndirizziFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_indirizzo;

    @OneToOne
    @JoinColumn(name = "id_fisica", referencedColumnName = "id_fisica")
    private PersonaFisica personaFisica;

    @Column(nullable = false) // Campo obbligatorio
    private String indiDomicilio;

    @Column(nullable = false) // Campo obbligatorio
    private String indiResidenza;

    public IndirizziFisica() {
    }

    public IndirizziFisica(Integer id_indirizzo, String indiDomicilio, String indiResidenza) {
        this.id_indirizzo = id_indirizzo;
        this.indiDomicilio = indiDomicilio;
        this.indiResidenza = indiResidenza;
    }

    public IndirizziFisica(String indiDomicilio, String indiResidenza) {
        this.indiDomicilio = indiDomicilio;
        this.indiResidenza = indiResidenza;
    }

    public Integer getId_indirizzo() {
        return id_indirizzo;
    }

    public PersonaFisica getPersonaFisica() {
        return personaFisica;
    }

    public String getIndiDomicilio() {
        return indiDomicilio;
    }

    public void setIndiDomicilio(String indiDomicilio) {
        this.indiDomicilio = indiDomicilio;
    }

    public String getIndiResidenza() {
        return indiResidenza;
    }

    public void setIndiResidenza(String indiResidenza) {
        this.indiResidenza = indiResidenza;
    }
}

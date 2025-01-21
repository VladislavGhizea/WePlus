package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_sede;

    @ManyToOne
    @JoinColumn(name = "giuridica_id")
    @JsonIgnore
    private PersonaGiuridica personaGiuridica;

    @ManyToOne
    @JoinColumn(name = "individuale_id")
    @JsonIgnore
    private EntitaIndividuale entitaIndividuale;

    @Column(nullable = false) // Campo obbligatorio
    private String indirizzo;

    @Column(nullable = false) // Campo obbligatorio
    private boolean principale = false;

    @Transient
    private Integer personaGiuridicaId;

    @Transient
    private Integer entitaIndividualeId;

    public Sede() {}

    public Sede(Integer personaGiuridicaId, boolean principale, String indirizzo) {
        this.personaGiuridicaId = personaGiuridicaId;
        this.principale = principale;
        this.indirizzo = indirizzo;
        this.entitaIndividualeId=null;
    }

    public void setEntitaIndividuale(EntitaIndividuale entitaIndividuale) {
        this.entitaIndividuale = entitaIndividuale;
    }

    public EntitaIndividuale getEntitaIndividuale() {
        return entitaIndividuale;
    }

    public Integer getEntitaIndividualeId() {
        return entitaIndividualeId;
    }

    public Sede(Integer entitaIndividualeId, String indirizzo, boolean principale) {
        this.entitaIndividualeId = entitaIndividualeId;
        this.indirizzo = indirizzo;
        this.principale = principale;
        this.personaGiuridicaId=null;
    }

    public void setPersonaGiuridica(PersonaGiuridica personaGiuridica) {
        this.personaGiuridica = personaGiuridica;
    }

    public PersonaGiuridica getPersonaGiuridica() {
        return personaGiuridica;
    }

    public Integer getPersonaGiuridicaId() {
        return personaGiuridicaId;
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

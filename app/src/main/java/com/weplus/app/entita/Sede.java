package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "Sede")
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "sede_id")
    private Integer sede_id;

    @ManyToOne
    @JoinColumn(name = "giuridica_id", insertable = false, updatable = false)
    @JsonIgnore
    private PersonaGiuridica personaGiuridica;

    @ManyToOne
    @JoinColumn(name = "entita_id", insertable = false, updatable = false)
    @JsonIgnore
    private EntitaIndividuale entitaIndividuale;

    @Column(nullable = false) // Campo obbligatorio
    private String indirizzo;

    @Column(nullable = false) // Campo obbligatorio
    private boolean principale = false;

    @Column(name = "giuridica_id", insertable = true, updatable = true)
    private Integer personaGiuridicaId;

    @Column(name = "entita_id", insertable = true, updatable = true)
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

    @JsonProperty("entitaIndividualeId")
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

    @JsonProperty("personaGiuridicaId")
    public Integer getPersonaGiuridicaId() {
        return personaGiuridicaId;
    }

    public Integer getSede_id() {
        return sede_id;
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

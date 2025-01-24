package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "IndirizziFisica")
public class IndirizzoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "indirizzo_id")
    private Integer indirizzo_id;

    @OneToOne
    @JoinColumn(name = "soggetto_id", referencedColumnName = "soggetto_id", insertable = false, updatable = false)
    @JsonIgnore
    private UtenteGenerale utenteGenerale;

    @Column(nullable = false, length = 50) // Campo obbligatorio
    private String indiDomicilio;

    @Column(nullable = false, length = 50) // Campo obbligatorio
    private String indiResidenza;

    @Column(name = "soggetto_id", insertable = true, updatable = true, nullable = false, unique = true)
    private Integer soggettoId;  // ID della FK

    public IndirizzoFisica() {
    }

    public IndirizzoFisica(Integer soggettoId, String indiDomicilio, String indiResidenza) {
        this.indiDomicilio = indiDomicilio;
        this.indiResidenza = indiResidenza;
        this.soggettoId=soggettoId;
    }

    public Integer getIndirizzo_id() {
        return indirizzo_id;
    }

    public UtenteGenerale getUtenteGenerale() {
        return utenteGenerale;
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

    @JsonProperty("soggettoId")
    public Integer getSoggettoId() {
        return soggettoId;
    }

    public void setUtenteGenerale(UtenteGenerale utenteGenerale) {
        this.utenteGenerale = utenteGenerale;
    }
}

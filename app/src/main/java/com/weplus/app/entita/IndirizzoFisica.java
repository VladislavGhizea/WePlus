package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "IndirizziFisica")
public class IndirizzoFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_indirizzo;

    @OneToOne
    @JoinColumn(name = "soggetto_id", referencedColumnName = "soggetto_id")
    private UtenteGenerale utenteGenerale;

    @Column(nullable = false) // Campo obbligatorio
    private String indiDomicilio;

    @Column(nullable = false) // Campo obbligatorio
    private String indiResidenza;

    public IndirizzoFisica() {
    }

    public IndirizzoFisica(String indiDomicilio, String indiResidenza) {
        this.indiDomicilio = indiDomicilio;
        this.indiResidenza = indiResidenza;
    }

    public Integer getId_indirizzo() {
        return id_indirizzo;
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


}

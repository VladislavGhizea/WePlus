package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Documenti")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_documento;

    @Column(nullable = false, length = 15)
    private String tipo;

    @Column(nullable = true)
    private Integer numero;

    @Column
    private Date scadenza;

    @Column(length = 25)
    private String enteEmissivo;

    @Column
    private Date dataEmissione;

    @ManyToOne
    @JoinColumn(name = "soggetto_id", nullable = false, referencedColumnName = "id_generale")
    @JsonIgnore
    private UtenteGenerale soggetto;

    @Transient
    private Integer soggettoId;

    public void setSoggettoId(Integer soggettoId) {
        this.soggettoId = soggettoId;
    }

    public Integer getSoggettoId() {
        return soggetto != null ? soggetto.getId_generale() : soggettoId;
    }

    public Documento() {
    }

    public Documento(String tipo,
                     Integer numero,
                     Date scadenza,
                     String enteEmissivo,
                     Date dataEmissione,
                     UtenteGenerale soggetto) {
        this.tipo = tipo;
        this.numero = numero;
        this.scadenza = scadenza;
        this.enteEmissivo = enteEmissivo;
        this.dataEmissione = dataEmissione;
        this.soggetto = soggetto;
    }

    // Getter e Setter
    public Integer getId_documento() {
        return id_documento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public String getEnteEmissivo() {
        return enteEmissivo;
    }

    public void setEnteEmissivo(String enteEmissivo) {
        this.enteEmissivo = enteEmissivo;
    }

    public Date getDataEmissione() {
        return dataEmissione;
    }

    public void setDataEmissione(Date dataEmissione) {
        this.dataEmissione = dataEmissione;
    }

    public UtenteGenerale getSoggetto() {
        return soggetto;
    }

    public void setSoggetto(UtenteGenerale soggetto) {
        this.soggetto = soggetto;
    }
}

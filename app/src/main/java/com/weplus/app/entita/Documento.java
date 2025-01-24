package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weplus.app.entita.listaEnum.TipoDoc;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Documenti")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer documento_id;

    @Column(nullable = false)
    private TipoDoc tipo;

    @Column(nullable = true)
    private Integer numero;

    @Column
    private Date scadenza;

    @Column(length = 25)
    private String enteEmissivo;

    @Column
    private Date dataEmissione;

    @ManyToOne
    @JoinColumn(name = "soggetto_id", nullable = false, insertable = false, updatable = false)  // Qui
    @JsonIgnore
    private UtenteGenerale soggetto;

    @Column(name = "soggetto_id", insertable = true, updatable = true)
    private Integer soggettoId;  // ID della FK

    public void setSoggettoId(Integer soggettoId) {
        this.soggettoId = soggettoId;
    }

    @JsonProperty("soggettoId")
    public Integer getSoggettoId() {
        return soggettoId;
    }

    public Documento() {
    }

    public Documento(TipoDoc tipo,
                     Integer numero,
                     Date scadenza,
                     String enteEmissivo,
                     Date dataEmissione,
                     Integer soggettoId) {
        this.tipo = tipo;
        this.numero = numero;
        this.scadenza = scadenza;
        this.enteEmissivo = enteEmissivo;
        this.dataEmissione = dataEmissione;
        this.soggettoId = soggettoId;

    }

    // Getter e Setter
    public Integer getDocumento_id() {
        return documento_id;
    }

    public TipoDoc getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoc tipo) {
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

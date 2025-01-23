package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weplus.app.entita.listaEnum.TipoPersGiur;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PersonaGiuridica")
public class PersonaGiuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "giuridica_id")
    private Integer giuridica_id;

    @OneToOne
    @JoinColumn(name = "soggetto_id", nullable = false, unique = true, insertable = false, updatable = false)
    @JsonIgnore
    private UtenteGenerale utenteGenerale;

    @Column(nullable = false, length = 11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false) // Campo obbligatorio
    private TipoPersGiur tipo;

    @Column(nullable = true, length = 25) // Campo opzionale
    private String ragione_sociale;

    @OneToMany
    @JoinColumn(name = "sede_id", nullable = false, insertable = false, updatable = false)
    @JsonIgnore
    private List<Sede> sede;

    @Column(name = "soggetto_id", insertable = true, updatable = true, unique = true)
    private Integer utenteGeneraleId;

    public PersonaGiuridica() {
    }


    public PersonaGiuridica(Integer utenteGeneraleId,
                            String partitaIva,
                            TipoPersGiur tipo,
                            String ragione_sociale) {
        this.utenteGeneraleId = utenteGeneraleId;
        this.partitaIva = partitaIva;
        this.tipo = tipo;
        this.ragione_sociale = ragione_sociale;
    }

    public Integer getGiuridica_id() {
        return giuridica_id;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public TipoPersGiur getTipo() {
        return tipo;
    }

    public String getRagione_sociale() {
        return ragione_sociale;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public void setTipo(TipoPersGiur tipo) {
        this.tipo = tipo;
    }

    public void setRagione_sociale(String ragione_sociale) {
        this.ragione_sociale = ragione_sociale;
    }

    public UtenteGenerale getUtenteGenerale() {
        return utenteGenerale;
    }

    public List<Sede> getSede() {
        return sede;
    }

    @JsonProperty("utenteGeneraleId")
    public Integer getUtenteGeneraleId() {
        return utenteGeneraleId;
    }

    public void setUtenteGenerale(UtenteGenerale utenteGenerale) {
        this.utenteGenerale = utenteGenerale;
    }


}

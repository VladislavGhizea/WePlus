package com.weplus.app.entita;

import com.weplus.app.entita.listaEnum.TipoPersGiur;
import jakarta.persistence.*;

@Entity
@Table(name = "PersonaGiuridica")
public class PersonaGiuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_giuridica;

    @OneToOne
    @JoinColumn(name = "generale_id", nullable = false, unique = true)
    private UtenteGenerale utenteGenerale;

    @Column(nullable = false, length = 11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false) // Campo obbligatorio
    private TipoPersGiur tipo;

    @Column(nullable = true, length = 25) // Campo opzionale
    private String ragione_sociale;

    @OneToOne
    @JoinColumn(name = "indirizzoFisica_id", nullable = false) // Associazione con entità
    private IndirizzoFisica indirizzoFisica;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sede sede;

    public PersonaGiuridica() {
    }

    public PersonaGiuridica(Integer id_giuridica,
                            UtenteGenerale utenteGenerale,
                            String partitaIva,
                            TipoPersGiur tipo,
                            String ragione_sociale,
                            IndirizzoFisica indirizzoFisica,
                            Sede sede) {
        this.id_giuridica = id_giuridica;
        this.utenteGenerale = utenteGenerale;
        this.partitaIva = partitaIva;
        this.tipo = tipo;
        this.ragione_sociale = ragione_sociale;
        this.indirizzoFisica = indirizzoFisica;
        this.sede = sede;
    }

    public PersonaGiuridica(UtenteGenerale utenteGenerale,
                            String partitaIva,
                            TipoPersGiur tipo,
                            String ragione_sociale,
                            IndirizzoFisica indirizzoFisica,
                            Sede sede) {
        this.utenteGenerale = utenteGenerale;
        this.partitaIva = partitaIva;
        this.tipo = tipo;
        this.ragione_sociale = ragione_sociale;
        this.indirizzoFisica = indirizzoFisica;
        this.sede = sede;
    }

    public Integer getId_giuridica() {
        return id_giuridica;
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

    public IndirizzoFisica getIndirizzoFisica() {
        return indirizzoFisica;
    }

    public Sede getSede() {
        return sede;
    }

    public void setIndirizzoFisica(IndirizzoFisica indirizzoFisica) {
        this.indirizzoFisica = indirizzoFisica;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
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
}

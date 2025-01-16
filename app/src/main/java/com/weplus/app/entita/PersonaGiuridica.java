package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonaGiuridica")
public class PersonaGiuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_giuridica;

    @OneToOne //imlementare il join con idgenrale
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer generale_id;

    @Column(nullable = false, length=11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false) // Campo obbligatorio
    private TipoPersGiur tipo;

    @Column(nullable = true, length=25) // Campo obbligatorio
    private String ragione_sociale;

    @OneToOne //imlementare il join con id_sede
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer indirizzoFisica_id;

    @OneToOne //imlementare il join con id_sede
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer indirizzoSede_id ;

    public PersonaGiuridica() {
    }

    public PersonaGiuridica(Integer id_giuridica, Integer indirizzoSede_id, Integer indirizzoFisica_id,
                            String ragione_sociale, TipoPersGiur tipo, String partitaIva,
                            Integer generale_id) {
        this.id_giuridica = id_giuridica;
        this.indirizzoSede_id = indirizzoSede_id;
        this.indirizzoFisica_id = indirizzoFisica_id;
        this.ragione_sociale = ragione_sociale;
        this.tipo = tipo;
        this.partitaIva = partitaIva;
        this.generale_id = generale_id;
    }

    public Integer getId_giuridica() {
        return id_giuridica;
    }

    public Integer getGenerale_id() {
        return generale_id;
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

    public Integer getIndirizzoFisica_id() {
        return indirizzoFisica_id;
    }

    public Integer getIndirizzoSede_id() {
        return indirizzoSede_id;
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
}

package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "EntitaIndividuali")
public class EntitaIndividuali {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_entita;

    @OneToOne //imlementare il join con idgenrale
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer generale_id;

    @Column(nullable = false, length=20) // Campo obbligatorio
    private String nome;

    @Column(nullable = false, length=20) // Campo obbligatorio
    private String cognome;

    @Column(nullable = false, length=16) // Campo obbligatorio
    private String cf;

    @Column(nullable = false) // Campo obbligatorio
    private Sesso sesso;

    @Column(nullable = false) // Campo obbligatorio
    private Genere genere;

    @Column(nullable = false, length=2) // Campo obbligatorio
    private String comuneDiN;

    @Column(nullable = false) // Campo obbligatorio
    private String dataDiN;

    @OneToOne //configura anche nella tab indirizzi
    @Column(nullable = false) // Campo obbligatorio
    private String indirizzo_id;

    @Column(nullable = false, length=11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false) // Campo obbligatorio
    private TipoPersGiur tipo;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String ragione_sociale;

    @OneToOne //imlementare il join con id_sede
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer sede_id;

    public EntitaIndividuali() {
    }

    public EntitaIndividuali(Integer id_entita, Integer generale_id, String partitaIva,
                            TipoPersGiur tipo, String ragione_sociale, Integer sede_id) {
        this.id_entita = id_entita;
        this.generale_id = generale_id;
        this.partitaIva = partitaIva;
        this.tipo = tipo;
        this.ragione_sociale = ragione_sociale;
        this.sede_id = sede_id;
    }

    public Integer getSede_id() {
        return sede_id;
    }

    public String getRagione_sociale() {
        return ragione_sociale;
    }

    public TipoPersGiur getTipo() {
        return tipo;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public Integer getGenerale_id() {
        return generale_id;
    }

    public Integer getId_giuridica() {
        return id_entita;
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

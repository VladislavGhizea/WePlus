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

    public EntitaIndividuali() {}

    public EntitaIndividuali(Integer id_entita, Integer generale_id, String nome,
                             String cognome, String cf, Sesso sesso, Genere genere,
                             String comuneDiN, String dataDiN, String indirizzo_id,
                             String partitaIva, TipoPersGiur tipo, String ragione_sociale,
                             Integer sede_id) {
        this.id_entita = id_entita;
        this.generale_id = generale_id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.sesso = sesso;
        this.genere = genere;
        this.comuneDiN = comuneDiN;
        this.dataDiN = dataDiN;
        this.indirizzo_id = indirizzo_id;
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

    public String getIndirizzo_id() {
        return indirizzo_id;
    }

    public String getDataDiN() {
        return dataDiN;
    }

    public String getComuneDiN() {
        return comuneDiN;
    }

    public Genere getGenere() {
        return genere;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public String getCf() {
        return cf;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getGenerale_id() {
        return generale_id;
    }

    public Integer getId_entita() {
        return id_entita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setComuneDiN(String comuneDiN) {
        this.comuneDiN = comuneDiN;
    }

    public void setDataDiN(String dataDiN) {
        this.dataDiN = dataDiN;
    }

    public void setIndirizzo_id(String indirizzo_id) {
        this.indirizzo_id = indirizzo_id;
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

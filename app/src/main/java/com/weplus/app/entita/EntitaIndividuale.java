package com.weplus.app.entita;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weplus.app.entita.listaEnum.Genere;
import com.weplus.app.entita.listaEnum.Sesso;
import com.weplus.app.entita.listaEnum.TipoPersGiur;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "EntitaIndividuali")
public class EntitaIndividuale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    @Column(name = "entita_id")
    private Integer entita_id;

    @OneToOne
    @JoinColumn(name = "soggetto_id", nullable = false, unique = true, insertable = false, updatable = false)
    @JsonIgnore
    private UtenteGenerale utenteGenerale;

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
    @JoinColumn(name = "indirizzo_id", nullable = false, insertable = false, updatable = false) // Campo obbligatorio
    @JsonIgnore
    private IndirizzoFisica indirizzoFisica;

    @Column(nullable = false, length=11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String ragioneSociale;

    @OneToMany(mappedBy = "entitaIndividuale", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Sede> sedi;

    @Column(name = "soggetto_id", insertable = true, updatable = true)
    private Integer utenteGeneraleId;

    @Column(name = "indirizzo_id", insertable = true, updatable = true)
    private Integer indirizzoFisicaId;


    public EntitaIndividuale() {}

    public EntitaIndividuale(Integer utenteGeneraleId,
                             String nome,
                             String cognome,
                             String cf,
                             Sesso sesso,
                             Genere genere,
                             String comuneDiN,
                             String dataDiN,
                             Integer indirizzoFisicaId,
                             String partitaIva,
                             String ragioneSociale){
        this.utenteGeneraleId = utenteGeneraleId;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.sesso = sesso;
        this.genere = genere;
        this.comuneDiN = comuneDiN;
        this.dataDiN = dataDiN;
        this.indirizzoFisicaId = indirizzoFisicaId;
        this.partitaIva = partitaIva;
        this.ragioneSociale = ragioneSociale;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public IndirizzoFisica getIndirizzoFisica() {
        return indirizzoFisica;
    }

    public void setUtenteGenerale(UtenteGenerale utenteGenerale) {
        this.utenteGenerale = utenteGenerale;
    }

    public void setIndirizzoFisica(IndirizzoFisica indirizzoFisica) {
        this.indirizzoFisica = indirizzoFisica;
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

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public UtenteGenerale getUtenteGenerale() {
        return utenteGenerale;
    }

    public List<Sede> getSedi() {
        return sedi;
    }

    @JsonProperty("utenteGeneraleId")
    public Integer getUtenteGeneraleId() {
        return utenteGeneraleId;
    }

    @JsonProperty("indirizzoFisicaId")
    public Integer getIndirizzoFisicaId() {
        return indirizzoFisicaId;
    }

    public Integer getEntita_id() {
        return entita_id;
    }


}

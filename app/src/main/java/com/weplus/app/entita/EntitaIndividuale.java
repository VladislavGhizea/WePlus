package com.weplus.app.entita;

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
    private Integer id_entita;

    @OneToOne
    @JoinColumn(name = "soggetto_id", nullable = false, unique = true)
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
    @JoinColumn(name = "indirizzoFisica_id", nullable = false) // Campo obbligatorio
    private IndirizzoFisica indirizzoFisica;

    @Column(nullable = false, length=11) // Campo obbligatorio
    private String partitaIva;

    @Column(nullable = false) // Campo obbligatorio
    private TipoPersGiur tipo;

    @Column(nullable = false, length=25) // Campo obbligatorio
    private String ragione_sociale;

    @OneToMany(mappedBy = "entitaIndividuale", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sede> sedi;

    @Transient
    private Integer utenteGeneraleId;

    @Transient
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
                             TipoPersGiur tipo,
                             String ragione_sociale){
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
        this.tipo = tipo;
        this.ragione_sociale = ragione_sociale;
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

    public List<Sede> getSedi() {
        return sedi;
    }

    public Integer getUtenteGeneraleId() {
        return utenteGeneraleId;
    }

    public Integer getIndirizzoFisicaId() {
        return indirizzoFisicaId;
    }
}

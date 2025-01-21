package com.weplus.app.entita;


import com.weplus.app.entita.listaEnum.Genere;
import com.weplus.app.entita.listaEnum.Sesso;
import jakarta.persistence.*;

@Entity
@Table(name = "PersoneFisiche")
public class PersonaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_fisica;

    @Column(nullable = false, length=20) // Campo obbligatorio
    private String nome;

    @Column(nullable = false, length=20) // Campo obbligatorio
    private String cognome;

    @OneToOne
    @JoinColumn(name = "soggetto_id", nullable = false, unique = true) // Relazione con UtenteGenerale
    private UtenteGenerale utenteGenerale;

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

    @OneToOne
    @JoinColumn(name = "indirizzo_id", nullable = false)
    private IndirizzoFisica indirizzo;

    @Transient
    private Integer indirizzoFisicaId;

    @Transient
    private Integer utenteGeneraleId;

    public PersonaFisica() {}


    public PersonaFisica(String nome,
                         String cognome,
                         Integer utenteGeneraleId,
                         String cf,
                         Sesso sesso,
                         Genere genere,
                         String comuneDiN,
                         String dataDiN,
                         Integer indirizzoFisicaId) {
        this.nome = nome;
        this.cognome = cognome;
        this.utenteGeneraleId = utenteGeneraleId;
        this.cf = cf;
        this.sesso = sesso;
        this.genere = genere;
        this.comuneDiN = comuneDiN;
        this.dataDiN = dataDiN;
        this.indirizzoFisicaId = indirizzoFisicaId;
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

    public UtenteGenerale getId_generale() {
        return utenteGenerale;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId_fisica() {
        return id_fisica;
    }

    public void setDataDiN(String dataDiN) {
        this.dataDiN = dataDiN;
    }

    public void setComuneDiN(String comuneDiN) {
        this.comuneDiN = comuneDiN;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public IndirizzoFisica getIndirizzo() {
        return indirizzo;
    }

    public void setUtenteGenerale(UtenteGenerale utenteGenerale) {
        this.utenteGenerale = utenteGenerale;
    }

    public void setIndirizzo(IndirizzoFisica indirizzo) {
        this.indirizzo = indirizzo;
    }

    public UtenteGenerale getUtenteGenerale() {
        return utenteGenerale;
    }

    public Integer getIndirizzoFisicaId() {
        return indirizzoFisicaId;
    }

    public Integer getUtenteGeneraleId() {
        return utenteGeneraleId;
    }
}



package com.weplus.app.entita;


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

    @OneToOne //imlementare il join con idgenrale
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_generale;

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

    public PersonaFisica() {
    }

    public PersonaFisica(Integer id_fisica, String nome, String cognome, Integer id_generale,
                         String cf, Sesso sesso, Genere genere, String comuneDiN, String dataDiN,
                         String indirizzo_id) {
        this.id_fisica = id_fisica;
        this.nome = nome;
        this.cognome = cognome;
        this.id_generale = id_generale;
        this.cf = cf;
        this.sesso = sesso;
        this.genere = genere;
        this.comuneDiN = comuneDiN;
        this.dataDiN = dataDiN;
        this.indirizzo_id = indirizzo_id;
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

    public Integer getId_generale() {
        return id_generale;
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

    public void setIndirizzo_id(String indirizzo_id) {
        this.indirizzo_id = indirizzo_id;
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
}

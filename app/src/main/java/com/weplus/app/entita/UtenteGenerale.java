package com.weplus.app.entita;

import com.weplus.app.entita.listaEnum.Tipo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "UtentiGenerali")
public class UtenteGenerale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_generale;

    @OneToOne(mappedBy = "utenteGenerale", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonaFisica personaFisica;

    @OneToOne(mappedBy = "utenteGenerale", cascade = CascadeType.ALL, orphanRemoval = true)
    private PersonaGiuridica personaGiuridica;

    @OneToOne(mappedBy = "utenteGenerale", cascade = CascadeType.ALL, orphanRemoval = true)
    private EntitaIndividuale entitaIndividuale;

    @Column(nullable = false) // Campo obbligatorio
    private String username;

    @Column(nullable = false, unique = true) // Campo obbligatorio e univoco
    private String email;

    @Column(nullable = false) // Campo obbligatorio
    private String password;

    @Column(nullable = false) // Campo obbligatorio
    private Tipo tipo;

    @Column(nullable = false) // Campo obbligatorio
    private boolean cancellato=false;


    @OneToMany(mappedBy = "soggetto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documenti;

    public UtenteGenerale(String pazzo, String mail, String moltopazzo69, Tipo fisica, boolean b) {}

    public UtenteGenerale(String username, String email, String password, Tipo tipo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }


    public Integer getId_generale() {
        return id_generale;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isCancellato() {
        return cancellato;
    }

    public void setCancellato(boolean cancellato) {
        this.cancellato = cancellato;
    }

    @Override
    public String toString() {
        return "UtenteGenerale{" +
                "id_generale=" + id_generale.toString() +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipo=" + tipo +
                ", cancellato=" + cancellato +
                '}';
    }
}

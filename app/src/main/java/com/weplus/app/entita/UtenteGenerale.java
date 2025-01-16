package com.weplus.app.entita;

import jakarta.persistence.*;

@Entity
@Table(name = "UtentiGenerali")
public class UtenteGenerale {

    @Id
    @OneToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID auto-increment
    private Integer id_generale;

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

    public UtenteGenerale() {}

    public UtenteGenerale(String username, String email, String password, Tipo tipo, boolean cancellato) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.cancellato = cancellato;
    }

    public UtenteGenerale(Integer id_generale, String username, String email, String password, Tipo tipo, boolean cancellato) {
        this.id_generale = id_generale;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
        this.cancellato = cancellato;
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

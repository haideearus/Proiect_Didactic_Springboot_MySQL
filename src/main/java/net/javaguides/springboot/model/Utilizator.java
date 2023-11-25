package net.javaguides.springboot.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name="utilizatori")
public class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_utilizator;
    @Column(name = "nume")
    private String nume;
    @Column(name = "utilizator")
    private String utilizator;
    @Column(name="parola")
    private String parola;
    @Column(name="nivel_acces")
    private String nivel_acces;

    public Long getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(Long id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getNivel_acces() {
        return nivel_acces;
    }

    public void setNivel_acces(String nivel_acces) {
        this.nivel_acces = nivel_acces;
    }

    public Utilizator() {
    }

    public Utilizator( String nume, String utilizator, String parola, String nivel_acces) {
       super();
        this.nume = nume;
        this.utilizator = utilizator;
        this.parola = parola;
        this.nivel_acces = nivel_acces;
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id_utilizator=" + id_utilizator +
                ", nume='" + nume + '\'' +
                ", utilizator='" + utilizator + '\'' +
                ", parola='" + parola + '\'' +
                ", nivel_acces=" + nivel_acces +
                '}';
    }
}
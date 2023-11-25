package net.javaguides.springboot.web.dto;

public class UtilizatorRegistrationDto {

    private String nume;
    private String utilizator;
    private String parola;

    public UtilizatorRegistrationDto() {
    }

    public UtilizatorRegistrationDto(String nume, String utilizator, String parola) {
        this.nume = nume;
        this.utilizator = utilizator;
        this.parola = parola;
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
}

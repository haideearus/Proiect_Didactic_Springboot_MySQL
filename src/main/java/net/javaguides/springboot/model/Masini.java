package net.javaguides.springboot.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "masini")
public class Masini {

    @Id
    @Column(name = "nr_inmatriculare", nullable = false)
    private String nr_inmatriculare;

    @Column(name = "id_utilizator", nullable = false)
    private int id_utilizator;

    @Column(name = "marca")
    private String marca;

    @Column(name = "model")
    private String model;

    @Column(name = "culoare")
    private String culoare;

    @Column(name = "anul_fabricatiei")
    private int anul_fabricatiei;

    @Column(name = "capacitatea_cilindrica")
    private Integer capacitate_cilindrica;

    @Column(name = "tipul_de_combustibil")
    private String tipul_de_combustibil;

    @Column(name = "puterea")
    private Integer putere;

    @Column(name = "cuplul")
    private int cuplul;

    @Column(name = "volumul_portbagajului")
    private int volumul_portbagajului;


    @Column(name = "pret", nullable = false, columnDefinition = "DECIMAL(10, 2) DEFAULT 0.00")
    private BigDecimal pretul = BigDecimal.ZERO;

    public Masini() {
    }

    public Masini(String nr_inmatriculare, int id_utilizator, String marca, String modelul, String culoare, int anul_fabricatiei, Integer capacitate_cilindrica, String tipul_de_combustibil, Integer putere, int cuplul, int volumul_portbagajului, BigDecimal pretul) {
        this.nr_inmatriculare = nr_inmatriculare;
        this.id_utilizator = id_utilizator;
        this.marca = marca;
        this.model = modelul;
        this.culoare = culoare;
        this.anul_fabricatiei = anul_fabricatiei;
        this.capacitate_cilindrica = capacitate_cilindrica;
        this.tipul_de_combustibil = tipul_de_combustibil;
        this.putere = putere;
        this.cuplul = cuplul;
        this.volumul_portbagajului = volumul_portbagajului;
        this.pretul = pretul;
    }

    public String getNr_inmatriculare() {
        return nr_inmatriculare;
    }

    public void setNr_inmatriculare(String nr_inmatriculare) {
        this.nr_inmatriculare = nr_inmatriculare;
    }

    public int getId_utilizator() {
        return id_utilizator;
    }

    public void setId_utilizator(int id_utilizator) {
        this.id_utilizator = id_utilizator;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public int getAnul_fabricatiei() {
        return anul_fabricatiei;
    }

    public void setAnul_fabricatiei(int anul_fabricatiei) {
        this.anul_fabricatiei = anul_fabricatiei;
    }

    public Integer getCapacitate_cilindrica() {
        return capacitate_cilindrica;
    }

    public void setCapacitate_cilindrica(Integer capacitate_cilindrica) {
        this.capacitate_cilindrica = capacitate_cilindrica;
    }

    public String getTipul_de_combustibil() {
        return tipul_de_combustibil;
    }

    public void setTipul_de_combustibil(String tipul_de_combustibil) {
        this.tipul_de_combustibil = tipul_de_combustibil;
    }

    public Integer getPutere() {
        return putere;
    }

    public void setPutere(Integer putere) {
        this.putere = putere;
    }

    public int getCuplul() {
        return cuplul;
    }

    public void setCuplul(int cuplul) {
        this.cuplul = cuplul;
    }

    public int getVolumul_portbagajului() {
        return volumul_portbagajului;
    }

    public void setVolumul_portbagajului(int volumul_portbagajului) {
        this.volumul_portbagajului = volumul_portbagajului;
    }

    public BigDecimal getPretul() {
        return pretul;
    }

    public void setPretul(BigDecimal pretul) {
        this.pretul = pretul;
    }

    @Override
    public String toString() {
        return "Masini{" +
                "nr_inmatriculare='" + nr_inmatriculare + '\'' +
                ", id_utilizator=" + id_utilizator +
                ", marca='" + marca + '\'' +
                ", modelul='" + model + '\'' +
                ", culoare='" + culoare + '\'' +
                ", anul_fabricatiei=" + anul_fabricatiei +
                ", capacitate_cilindrica=" + capacitate_cilindrica +
                ", tipul_de_combustibil='" + tipul_de_combustibil + '\'' +
                ", putere=" + putere +
                ", cuplul=" + cuplul +
                ", volumul_portbagajului=" + volumul_portbagajului +
                ", pretul=" + pretul +
                '}';
    }

    // getters and settere


}

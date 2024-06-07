package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;


@Entity
public class Vizitka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 100)
    @NotBlank
    private String celeJmeno;

    @Length(max = 100)
    @NotBlank
    private String firma;

    @Length(max = 100)
    @NotBlank
    private String ulice;

    @Length(max = 100)
    @NotBlank
    private String obec;

    @Length(max = 100)
    @NotBlank
    private String psc;

    @Length(max = 100)
    private String email;

    @Length(min = 9, max = 13)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    private String web;

    public Vizitka() {
    }

    public Vizitka(String celeJmeno, String firma, String ulice, String obec, String psc, String email, String telefon, String web) {
        this.celeJmeno = Objects.requireNonNull(celeJmeno);
        this.firma = Objects.requireNonNull(firma);
        this.ulice = Objects.requireNonNull(ulice);
        this.obec = Objects.requireNonNull(obec);
        this.psc = Objects.requireNonNull(psc);
        this.email = email;
        this.telefon = telefon;
        this.web = web;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setceleJmeno(String jmeno) {
        this.celeJmeno = Objects.requireNonNull(jmeno);
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = Objects.requireNonNull(firma);
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = Objects.requireNonNull(ulice);
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = Objects.requireNonNull(obec);
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = Objects.requireNonNull(psc);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa() {
        return ulice + ", " + obec + ", " + psc;
    }
}
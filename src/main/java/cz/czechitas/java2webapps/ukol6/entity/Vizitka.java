package cz.czechitas.java2webapps.ukol6.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;


import java.beans.Transient;
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
    @NotBlank
    private String email;

    @Length(min = 9, max = 13)
    @NotBlank
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    @NotBlank
    private String web;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCeleJmeno() {

        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {

        this.celeJmeno = Objects.requireNonNull(celeJmeno);
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
}
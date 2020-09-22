/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Josip
 */
@Entity
@Table(name = "vozilo")
public class Vozilo extends Entitet{

    private String naziv;
    private String model;
    private String registracijskaOznaka;
    private Boolean osigurano;
    private BigDecimal ukupnoPredjenihKm;
    private Date datumProizvodnje;
    
    @ManyToOne
    private Proizvodjac proizvodjac;

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistracijskaOznaka() {
        return registracijskaOznaka;
    }

    public void setRegistracijskaOznaka(String registracijskaOznaka) {
        this.registracijskaOznaka = registracijskaOznaka;
    }

    public Boolean getOsigurano() {
        return osigurano;
    }

    public void setOsigurano(Boolean osigurano) {
        this.osigurano = osigurano;
    }

    public BigDecimal getUkupnoPredjenihKm() {
        return ukupnoPredjenihKm;
    }

    public void setUkupnoPredjenihKm(BigDecimal ukupnoPredjenihKm) {
        this.ukupnoPredjenihKm = ukupnoPredjenihKm;
    }

    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(Date datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }
    

}

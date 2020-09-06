/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Josip
 */
@Entity
@Table(name = "vozilo")
public class Vozilo extends Etintet{

    private String registracijskaOznaka;
    private Boolean osiguran;
    private String bojaVozila;
    private BigDecimal ukupnoPredjenihKm;
    
    @ManyToOne
    private Proizvodjac proizvodjac;

    public Proizvodjac getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(Proizvodjac proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
    

    public BigDecimal getUkupnoPredjenihKm() {
        return ukupnoPredjenihKm;
    }

    public void setUkupnoPredjenihKm(BigDecimal ukupnoPredjenihKm) {
        this.ukupnoPredjenihKm = ukupnoPredjenihKm;
    }
   

    public String getRegistracijskaOznaka() {
        return registracijskaOznaka;
    }

    public void setRegistracijskaOznaka(String registracijskaOznaka) {
        this.registracijskaOznaka = registracijskaOznaka;
    }

    public Boolean getOsiguran() {
        return osiguran;
    }

    public void setOsiguran(Boolean osiguran) {
        this.osiguran = osiguran;
    }

    public String getBojaVozila() {
        return bojaVozila;
    }

    public void setBojaVozila(String bojaVozila) {
        this.bojaVozila = bojaVozila;
    }

  
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Josip
 */
@Entity
@Table(name = "proizvodjac")
public class Proizvodjac extends Etintet{
    
    private String naziv;
    private String model;
    private Integer brojVrata;
    private Integer kW;
    private Date datumProizvodnje;

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

    public Integer getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(Integer brojVrata) {
        this.brojVrata = brojVrata;
    }

    public Integer getkW() {
        return kW;
    }

    public void setkW(Integer kW) {
        this.kW = kW;
    }

    public Date getDatumProizvodnje() {
        return datumProizvodnje;
    }

    public void setDatumProizvodnje(Date datumProizvodnje) {
        this.datumProizvodnje = datumProizvodnje;
    }
    
    
}

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
@Table(name = "prijevoz")
public class Prijevoz extends Entitet {
    
   
    
    private String polaziste;
    private String odrediste;
    private BigDecimal ukupnoKm;
    private BigDecimal cijena;
    private Integer brojPutnika;
    
     @ManyToOne
    private Vozac vozac;

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    
     
    

    public String getPolaziste() {
        return polaziste;
    }

    public void setPolaziste(String polaziste) {
        this.polaziste = polaziste;
    }

    public String getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(String odrediste) {
        this.odrediste = odrediste;
    }

    public BigDecimal getUkupnoKm() {
        return ukupnoKm;
    }

    public void setUkupnoKm(BigDecimal ukupnoKm) {
        this.ukupnoKm = ukupnoKm;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Integer getBrojPutnika() {
        return brojPutnika;
    }

    public void setBrojPutnika(Integer brojPutnika) {
        this.brojPutnika = brojPutnika;
    }
    
    
    
}

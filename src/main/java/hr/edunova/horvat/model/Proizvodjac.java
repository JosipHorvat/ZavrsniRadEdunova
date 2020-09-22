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
public class Proizvodjac extends Entitet{
    
   
    private String nazivTvrtke;
    private String drzava;
    private String grad;
    private String webStranica;

    public String getNazivTvrtke() {
        return nazivTvrtke;
    }

    public void setNazivTvrtke(String nazivTvrtke) {
        this.nazivTvrtke = nazivTvrtke;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getWebStranica() {
        return webStranica;
    }

    public void setWebStranica(String webStranica) {
        this.webStranica = webStranica;
    }
   
}

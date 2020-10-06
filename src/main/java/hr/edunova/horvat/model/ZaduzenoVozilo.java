/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author Josip
 */
@Entity
public class ZaduzenoVozilo extends Entitet{
    
    private Date voziloZaduzeno;
    private Date voziloRazduzeno;
    
    
    
     @ManyToOne
    private Vozilo vozilo;
     
      @ManyToOne
    private Vozac vozac;

    public Date getVoziloZaduzeno() {
        return voziloZaduzeno;
    }

    public void setVoziloZaduzeno(Date voziloZaduzeno) {
        this.voziloZaduzeno = voziloZaduzeno;
    }

    public Date getVoziloRazduzeno() {
        return voziloRazduzeno;
    }

    public void setVoziloRazduzeno(Date voziloRazduzeno) {
        this.voziloRazduzeno = voziloRazduzeno;
    }

    public Vozilo getVozilo() {
        return vozilo;
    }

    public void setVozilo(Vozilo vozilo) {
        this.vozilo = vozilo;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    @Override
    public String toString() {
         // format datuma koji ce se ispisati u listi:
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        //U listi zaduzena vozila ispisat ce se ona koja su zaduzena i obrnuto
        if (getVoziloRazduzeno() == null) {
            return getVozac().getImeIPrezime() + " - " + getVozilo().getNaziv() + " " + getVozilo().getModel() + ":  " + dateFormat.format(getVoziloZaduzeno());
        } else {
            return getVozac().getImeIPrezime() + " - " + getVozilo().getNaziv() + " " + getVozilo().getModel() + ": " + dateFormat.format(getVoziloRazduzeno());
        }
               
    }
     
    
}

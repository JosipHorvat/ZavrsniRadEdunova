/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.model;

import javax.persistence.Entity;

/**
 *
 * @author Josip
 */
@Entity
public class Vozilo extends Etintet{
    
//    create table vozilo (
//sifra int not null primary key auto_increment,
//proizvodjac int not null,
//boja varchar(50) not null,
//registracijskaOznaka varchar(20) not null
//);
    private String registracijskaOznaka;
    private Boolean osiguran;
    private String bojaVozila;
    private Integer brojVrata;

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

    public Integer getBrojVrata() {
        return brojVrata;
    }

    public void setBrojVrata(Integer brojVrata) {
        this.brojVrata = brojVrata;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Vozilo;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.utility.PomocnaMetoda;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Josip
 */
public class ObradaVozilo extends Obrada<Vozilo>{
    
     @Override
    public List<Vozilo> getPodaci() {
         return session.createQuery("from Vozilo").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        kontrolaBojaVozila();
        kontrolaRegistracijskaOznaka();
        kontrolaUkupnoPredjenihKm();
        kontrolaOsiguran();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void kontrolaDelete() throws MyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//OVDJE SE VRATITI I POGLEDAT DA BOLJE UPISEM BIG DECIMAL 
// I pregledati ostale kontrole ako nesto moze bolje

   private void kontrolaBojaVozila() throws MyException{
       PomocnaMetoda.neMozeBitiBroj(entitet.getBojaVozila(),"Nepoznata boja");
       if(entitet.getBojaVozila()== null || entitet.getBojaVozila().trim().isEmpty()){
           throw new MyException("Boja vozila mora biti unesena");
       }
       if(entitet.getBojaVozila().length()>50){
           throw new MyException("Boja ne moze biti duza od 50 znakova ");
       }   
       
      
   }
   private void kontrolaRegistracijskaOznaka() throws MyException{
       if(entitet.getRegistracijskaOznaka()== null || entitet.getRegistracijskaOznaka().trim().isEmpty()){
           throw new MyException("Registracijska oznaka mora biti unesena");
       }
   }
   private void kontrolaUkupnoPredjenihKm() throws MyException{
       kontrolaNull(entitet.getUkupnoPredjenihKm(), "Mora se znati ukupan broj predjenih KM vozila");
       if(entitet.getUkupnoPredjenihKm().compareTo(BigDecimal.ZERO)<0){
           throw new MyException("Ukupan broj predjenih kilometara ne moze biti manji od 0");
       }
   }
   private void kontrolaOsiguran() throws MyException{
       if(entitet.getOsiguran()== null){
           throw new MyException("Mora se znati je li vozilo osigurano");
       }
   }
   
   private void kontrolaNull(Object o, String poruka)throws MyException{
         if(o==null){
           throw new MyException(poruka);
           }
       }
   
   


   
}

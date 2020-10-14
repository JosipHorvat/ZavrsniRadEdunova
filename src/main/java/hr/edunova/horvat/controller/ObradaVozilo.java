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
    
      public List<Vozilo> getPodaci(String uvjet) {
          return session.createQuery("from Vozilo v "
              + " where concat(v.naziv, ' ', v.model, ' ', v.registracijskaOznaka) "
              + " like :uvjet ")
              .setParameter("uvjet", "%"+uvjet+"%")
              .setMaxResults(20)
              .list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        kontrolaNaziva();
        kontrolaModel();
        kontrolaRegistracijskaOznaka();
        kontrolaUkupnoPredjenihKm();
        kontrolaDatum();
        kontrolaJedinstvenaRegistracijskaOznaka();
       
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        kontrolaNaziva();
        kontrolaModel();
        kontrolaRegistracijskaOznaka();
        kontrolaUkupnoPredjenihKm();
        kontrolaJedinstvenaRegistracijskaOznakaPromjeni();
       
    }

    @Override
    protected void kontrolaDelete() throws MyException {
          if(entitet.getZaduzenaVozila().size()>0){
            throw new MyException("Vozilo se ne može obrisati jer nije rijesena dokumentacija zaduzenog/razduzenog vozila");
        }
    }


   private void kontrolaNaziva() throws MyException{
       PomocnaMetoda.neMozeBitiBroj(entitet.getNaziv(),"Naziv ne moze biti broj");
       if(entitet.getNaziv()== null || entitet.getNaziv().trim().isEmpty()){
           throw new MyException("Naziv vozila mora biti unesen");
       }
       if(entitet.getNaziv().length()>50){
           throw new MyException("Naziv ne moze biti duzi od 50 znakova ");
       }
   }
   
   private void kontrolaModel() throws MyException{
       if(entitet.getModel()== null || entitet.getModel().trim().isEmpty()){
           throw new MyException("Naziv modela mora biti unesen");
       }
       if(entitet.getModel().length()>50){
           throw new MyException("Naziv ne moze biti duzi od 50 znakova ");
       } 
   }
 
   private void kontrolaRegistracijskaOznaka() throws MyException{
       if(entitet.getRegistracijskaOznaka()== null || entitet.getRegistracijskaOznaka().trim().isEmpty()){
           throw new MyException("Registracijska oznaka mora biti unesena");
       }
          
   }
   private void kontrolaJedinstvenaRegistracijskaOznaka() throws MyException{
       List<Vozilo> lista = session.createQuery(""
       + " FROM Vozilo v "
       + " WHERE v.registracijskaOznaka=:registracijskaOznaka "
       )
         .setParameter("registracijskaOznaka", entitet.getRegistracijskaOznaka())
         .list();
       if(lista.size()>0){
           throw new MyException("Registracijska oznaka je dodijeljena vozilu: "+ lista.get(0).getNaziv()+ " "
           + lista.get(0).getModel());
       }
       
   }
   private void kontrolaJedinstvenaRegistracijskaOznakaPromjeni() throws MyException{
           
        List<Vozilo> lista = session.createQuery(""
       + " FROM Vozilo v "
       + " WHERE v.registracijskaOznaka=:registracijskaOznaka and v.id!=:id "
       )
         .setParameter("registracijskaOznaka", entitet.getRegistracijskaOznaka())
         .setParameter("id", entitet.getId())
         .list();
       if(lista.size()>0){
           throw new MyException("Registracijska oznaka je dodijeljena vozilu: "+ lista.get(0).getNaziv()+ " "
           + lista.get(0).getModel());
       }
       }
 
    
  private void kontrolaUkupnoPredjenihKm() throws MyException{
       kontrolaNull(entitet.getUkupnoPredjenihKm(), "Mora se znati ukupan broj predjenih KM vozila");
       if(entitet.getUkupnoPredjenihKm().compareTo(BigDecimal.ZERO)<0){
           throw new MyException("Ukupan broj predjenih kilometara ne moze biti manji od 0");
       }
   } 
  private void kontrolaDatum()throws MyException{
      kontrolaNull(entitet.getDatumProizvodnje(), "Datum proizvodnje se mora unijeti");
  }
  
 
  
   private void kontrolaNull(Object o, String poruka)throws MyException{
         if(o==null){
           throw new MyException(poruka);
           }
       }
   
   // Ova kontrola je u Regex paterni da reg. oznaka mora biti u paterni: primjer(OS-123-OS)
   // Oznaka ce biti neispravna u bilo kojem drugom obliku.
   
   private void kontrolaRegexRegistracijskaOznaka()throws MyException{
         if (!entitet.getRegistracijskaOznaka().matches("^[a-žA-Ž]{2}-[0-9]{3}-[a-žA-Ž]{2}")) {
            throw new MyException("Neispravan unos registracijske oznake");
     }
   }
    
}

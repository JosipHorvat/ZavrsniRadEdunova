/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Proizvodjac;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.utility.PomocnaMetoda;
import java.util.List;

/**
 * @author Josip
 */
public class ObradaProizvodjac extends Obrada<Proizvodjac>{

    @Override
    public List<Proizvodjac> getPodaci() {
         return session.createQuery("from Proizvodjac").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        kontrolaNazivTvrtke();
        kontrolaDrzava();
        kontrolaGrad();
        // mozda kontrola webstranice
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        kontrolaNazivTvrtke();
        kontrolaDrzava();
        kontrolaGrad();
    }

    @Override
    protected void kontrolaDelete() throws MyException {
            if(entitet.getVozila().size()>0){
        throw new MyException("Proizvodjac se ne moze obrisati jer ima jedno ili vise vozila.");
    }
//               if(entitet.getVozila().size()>0){
//        throw new MyException("Proizvodjac se ne moze obrisati jer ima jedno ili vise vozila.");
//    }
    }
   
    private void kontrolaNazivTvrtke() throws MyException{
         PomocnaMetoda.neMozeBitiBroj(entitet.getNazivTvrtke(),"Naziv ne moze biti broj");
     if(entitet.getNazivTvrtke()== null || entitet.getNazivTvrtke().trim().isEmpty()){
         throw new MyException("Naziv tvrtke se mora unijeti");
     }   
    }
    
     private void kontrolaDrzava() throws MyException{
        PomocnaMetoda.neMozeBitiBroj(entitet.getDrzava(),"Ime Drzave ne moze biti broj");
     if(entitet.getDrzava()== null || entitet.getDrzava().trim().isEmpty()){
         throw new MyException("Ime drzave se mora unijeti");
     }   
     }
     
       private void kontrolaGrad() throws MyException{
        PomocnaMetoda.neMozeBitiBroj(entitet.getGrad(),"Ime Drzave ne moze biti broj");
     if(entitet.getGrad()== null || entitet.getGrad().trim().isEmpty()){
         throw new MyException("Ime grada se mora unijeti");
     }   
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Osoba;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.utility.Oib;
import hr.edunova.horvat.utility.PomocnaMetoda;

/**
 *
 * @author Josip
 */
public abstract class ObradaOsoba<T extends Osoba> extends Obrada<T>{

    @Override
    protected void kontrolaCreate() throws MyException {
     kontrolaIme();
     kontrolaPrezime();
     kontrolaOib();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
     kontrolaIme();
     kontrolaPrezime();
     kontrolaOib();

    }

    @Override
    protected void kontrolaDelete() throws MyException {
    
    }
    
    
    private void kontrolaIme() throws MyException{
     PomocnaMetoda.neMozeBitiBroj(entitet.getIme(),"Ime ne moze biti broj");
     if(entitet.getIme()== null || entitet.getIme().trim().isEmpty()){
         throw new MyException("Ime se mora unijeti");
     }
 }
    private void kontrolaPrezime() throws MyException{
     PomocnaMetoda.neMozeBitiBroj(entitet.getIme(), "Prezime ne moze biti broj");
     if(entitet.getPrezime()== null || entitet.getPrezime().trim().isEmpty()){
         throw new MyException("Prezime se mora unijeti");
     }
 }
    protected void kontrolaOib() throws MyException{
     if(entitet.getOib()==null || entitet.getOib().trim().isEmpty()){
         throw new MyException("Unos OIB-a je obavezan");
     }

     if(!Oib.isValjan(entitet.getOib())){
         throw new MyException("OIB nije valjan");
     }
    }
    
}

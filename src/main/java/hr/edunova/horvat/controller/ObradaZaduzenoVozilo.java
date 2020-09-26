/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.ZaduzenoVozilo;
import hr.edunova.horvat.utility.MyException;
import java.util.List;

/**
 *
 * @author Josip
 */
public class ObradaZaduzenoVozilo extends Obrada<ZaduzenoVozilo>{

    @Override
    public List<ZaduzenoVozilo> getPodaci() {
        return session.createQuery("from ZaduzenoVozilo").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void kontrolaDelete() throws MyException {
  
    }
    
}

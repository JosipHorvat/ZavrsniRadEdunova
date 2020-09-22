
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.utility.Oib;
import hr.edunova.horvat.utility.PomocnaMetoda;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Josip
 */
 // U obradi vozac je potrebna obrada za Date i mozda za ??Vozilo?? 
public class ObradaVozac extends ObradaOsoba<Vozac>{
    
      
     @Override
    public List<Vozac> getPodaci() {
        return session.createQuery("from Vozac").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        super.kontrolaCreate();
        
    }

    @Override
    protected void kontrolaUpdate() throws MyException {

    }

    @Override
    protected void kontrolaDelete() throws MyException {

    }
  
 
 
}

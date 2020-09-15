
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
public class ObradaVozac extends ObradaOsoba<Vozac>{
    
      
     @Override
    public List<Vozac> getPodaci() {
        return session.createQuery("from Vozac").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        super.kontrolaCreate();
        kontrolaVerificiran();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {

    }

    @Override
    protected void kontrolaDelete() throws MyException {

    }
 // U obradi vozac je potrebna obrada za Date i mozda za ??Vozilo??   
// za ovo upitati 
    private void kontrolaVerificiran() throws MyException{
        if(entitet.getVerificiran() == null){
            throw new MyException("Ne zna se je li vozac verificiran");
        }
        
    }
   
 
   
}

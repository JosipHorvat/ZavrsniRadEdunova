
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Prijevoz;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.utility.PomocnaMetoda;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;

/**
 * @author Josip
 */
public class ObradaPrijevoz extends Obrada<Prijevoz>{
    
        @Override
    public List<Prijevoz> getPodaci() {
       return session.createQuery("from Prijevoz").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        kontrolaPolaz();
        kontrolaDolaz();
        kontrolaCijene();
        kontrolaUkupnoKm();
        kontrolaBrojPutnika();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        
    }

    @Override
    protected void kontrolaDelete() throws MyException {

    }
    
    private void kontrolaPolaz() throws MyException{
     if(entitet.getPolaziste()== null || entitet.getPolaziste().trim().isEmpty()){
         throw new MyException("Mjesto polaska obavezno unijeti.");
     }
    }
    private void kontrolaDolaz() throws MyException{
     if(entitet.getOdrediste()== null || entitet.getOdrediste().trim().isEmpty()){
         throw new MyException("Mjesto odredista obavezno unijeti.");
     }   
    }
    
     private void kontrolaUkupnoKm() throws MyException{
         PomocnaMetoda.kontrolaNull(entitet.getUkupnoKm(), "Obavezno unijeti koliko je predjeno kilometara u voznji");
       if(entitet.getUkupnoKm().compareTo(BigDecimal.ZERO)<0){
           throw new MyException("Ukupan broj predjenih kilometara ne moze biti manji od 0");
       }
       
     }
     private void kontrolaCijene() throws MyException{
       PomocnaMetoda.kontrolaNull(entitet.getCijena(), "Cijena obavezna");
        if(entitet.getCijena().compareTo(BigDecimal.ZERO)<=0){
            throw new MyException("Cijena ne može biti manja ili jednaka nuli");
        }  
       
     }
     
     private void kontrolaBrojPutnika() throws MyException{
        PomocnaMetoda.kontrolaNull(entitet.getBrojPutnika(), "Obavezan broj putnika");
        if(entitet.getBrojPutnika()<1){
            throw new MyException("Ne moze biti manje od jednog putnika");
        }
        
        // NIJE DOBRO
//       try{
//          entitet.getBrojPutnika().toString();
//          
//       }catch(NumberFormatException e){
//         throw new MyException("Krivi unos");
//       }
     }    
    
}

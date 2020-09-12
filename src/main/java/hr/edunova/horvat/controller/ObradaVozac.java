
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
public class ObradaVozac extends Obrada<Vozac>{
    
    public ObradaVozac(Vozac vozac){
        super(vozac);
    }
    
    public ObradaVozac(){
        super();
    }
    
     @Override
    public List<Vozac> getPodaci() {
        return session.createQuery("from Vozac").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        kontrolaIme();
        kontrolaOib();
        kontrolaPrezime();
        kontrolaVerificiran();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {

    }

    @Override
    protected void kontrolaDelete() throws MyException {

    }
    
 private void kontrolaIme() throws MyException{
     PomocnaMetoda.neMozeBitiBroj(entitet.getIme(),"Ime ne moze biti broj");
     if(entitet.getIme()== null || entitet.getIme().isEmpty()){
         throw new MyException("Ime se mora unijeti");
     }
 }
 private void kontrolaPrezime() throws MyException{
     PomocnaMetoda.neMozeBitiBroj(entitet.getIme(), "Prezime ne moze biti broj");
     if(entitet.getPrezime()== null || entitet.getPrezime().isEmpty()){
         throw new MyException("Prezime se mora unijeti");
     }
 }
 protected void kontrolaOib() throws MyException{
     if(entitet.getOib()==null || entitet.getOib().isEmpty()){
         throw new MyException("Unos OIB-a je obavezan");
     }

     if(!Oib.isValjan(entitet.getOib())){
         throw new MyException("OIB nije valjan");
     }
    }
// za ovo upitati 
    private void kontrolaVerificiran() throws MyException{
        if(entitet.getVerificiran() == null){
            throw new MyException("Ne zna se je li vozac verificiran");
        }
        
    }
   
 
   
}

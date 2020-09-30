
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
    
    public List<Vozac> getPodaci(String uvjet) {
        return session.createQuery("from Vozac v "
              + " where concat(v.ime, ' ', v.prezime, ' ', v.oib) "
              + " like :uvjet ")
              .setParameter("uvjet", "%"+uvjet+"%")
              .setMaxResults(20)
              .list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        super.kontrolaCreate();
        kontrolaOibBazaKreiraj();
        
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        super.kontrolaUpdate();
    }

    @Override
    protected void kontrolaDelete() throws MyException {
          if(entitet.getZaduzenaVozila().size()>0){
            throw new MyException("Vozac se ne moze obrisati jer nije uklonjeno razduzeno/zaduzeno vozilo");
        }
    }
     private void kontrolaOibBazaKreiraj() throws MyException{
       List<Vozac> lista = session.createQuery(""
               + " from Vozac v "
               + " where v.oib=:oib "
               )
               .setParameter("oib", entitet.getOib())
               .list();
       if(lista.size()>0){
           throw new MyException("Oib je dodjeljen " + lista.get(0).getImeIPrezime()+ ", odaberite drugi OIB");
       }
       
    }
     
       private void kontrolaOibBazaPromjeni() throws MyException{
       List<Vozac> lista = session.createQuery(""
               + " from Vozac v "
               + " where v.oib=:oib and v.id!=:id"
               )
               .setParameter("oib", entitet.getOib())
               .setParameter("id", entitet.getId())
               .list();
       if(lista.size()>0){
           throw  new MyException("Oib je dodjeljen " + lista.get(0).getImeIPrezime() + ", odaberite drugi OIB");
       }
       
    }
 
 
}

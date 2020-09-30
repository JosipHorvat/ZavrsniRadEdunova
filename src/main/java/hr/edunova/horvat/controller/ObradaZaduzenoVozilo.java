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
        kontrolaDozvoleZaduzivanjaVozila();
        kontrolaDatumZaduziVozilo();
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        
    }

    @Override
    protected void kontrolaDelete() throws MyException {
  
    }
    private void kontrolaDozvoleZaduzivanjaVozila() throws MyException{
        
        List<ZaduzenoVozilo> lista = session.createQuery(""
                + " SELECT zv"
                + " FROM ZaduzenoVozilo AS zv"
                + " WHERE zv.vozac.id=:vozac_id and zv.vozilo.id=:vozilo_id and zv.voziloRazduzeno is null")
                .setParameter("vozac_id", entitet.getVozac().getId())
                .setParameter("vozilo_id", entitet.getVozilo().getId())
                .list();
        
        if(lista.size()>0){
            throw new MyException("Vozilo je dodijeljeno "+ lista.get(0).getVozac().getImeIPrezime() + ", Odaberite drugo Vozilo");
        }
        //dohvatiti iz baze sva nerazduzena vozila tog vozaca
        // ako je ta lista veca od 0 , ne mozete zaduziti vozilo dok prethodno niste razduzili
        //primjer je oib   
        }
    
   private void kontrolaDatumZaduziVozilo() throws MyException{
       
       if(entitet.getVoziloZaduzeno()== null){
           throw new MyException("Datum obavezan");
       }
   }
}

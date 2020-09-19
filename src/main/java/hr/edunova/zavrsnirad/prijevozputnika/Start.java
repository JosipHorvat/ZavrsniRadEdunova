package hr.edunova.zavrsnirad.prijevozputnika;

import hr.edunova.horvat.controller.ObradaVozac;
import hr.edunova.horvat.controller.ObradaVozilo;
import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.model.Vozilo;
import hr.edunova.horvat.utility.HibernateUtil;
import hr.edunova.horvat.utility.FakerPocetniInsert;
import hr.edunova.horvat.utility.MyException;
import hr.edunova.horvat.view.Autorizacija;
import hr.edunova.horvat.view.Test;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Josip
 */
public class Start {

    public static void main(String[] args) {
        
          /*
        Pregledati ponovno tecaj od nez koje minute!!
        
        Nastavak: Kontrola za Proizvodjac, Vozilo.
        Dodati u Vozac/Vozilo String ne moze biti broj
        Duzina veca od 50 znakova....
        */
  
        
//=============UNOS PODATAKA SA FAKER=============         
  //       FakerPocetniInsert.izvedi();
//============= AUTORIZACIJA JFRAME=======================       
  new Autorizacija().setVisible(true);
  
 //===========UNOS ADMINA I OPERATERA ============= 
    //FakerPocetniInsert.unosAdminOperatera();
 
//===========TEST ZA VOZILO========================     
//      Vozilo vozilo = new Vozilo();
//      vozilo.setBojaVozila("1");
//      vozilo.setUkupnoPredjenihKm(BigDecimal.ONE);
//      vozilo.setRegistracijskaOznaka("OS-705-IB");
//      vozilo.setOsiguran(Boolean.TRUE);
//     // vozilo.setProizvodjac(proizvodjac);
//      
//      ObradaVozilo obradaVozilo = new ObradaVozilo();
//        obradaVozilo.setEntitet(vozilo);
//        try {
//            obradaVozilo.create();
//          } catch (MyException ex) {
//              System.out.println(ex.getPoruka());
//        }   
            
            
 //=============TEST ZA VOZAC===================
//        Vozac vozac = new Vozac();
//        vozac.setIme("Tomo");
//        vozac.setOib("79335008696");
//        vozac.setPrezime("Horvat");
//        vozac.setEmail("josiph988@gmail.com");
//        vozac.setVerificiran(true);
//########  NAUCITI KAKO ODRADITI DATUM I STRANI KLJUC ##########
       // vozac.setVozilo(vozilo);
       // vozac.setDatumRodjenja();
       
//        ObradaVozac ov = new ObradaVozac();
//        ov.setEntitet(vozac);
//        try {
//            ov.create();
//        } catch (MyException ex) {
//            System.out.println(ex.getPoruka());
//        }


//============== FAKER POCETNI INSERT ===================
//       HibernateUtil.getSessionFactory().openSession();
//        FakerPocetniInsert.izvedi();
       
    }
}

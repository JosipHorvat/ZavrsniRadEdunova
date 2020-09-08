
package com.mycompany.zavrsniradprijevozputnika;

import hr.edunova.horvat.controller.ObradaVozac;
import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.utility.HibernateUtil;
import hr.edunova.horvat.utility.FakerPocetniInsert;
import hr.edunova.horvat.utility.MyException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author Josip
 */
public class Start {
    public static void main(String[] args) {
      //  HibernateUtil.getSessionFactory().openSession();
    //  FakerPocetniInsert.izvedi();
    Vozac vozac = new Vozac();
    
    ObradaVozac obradaVozac = new ObradaVozac(vozac);
    
        try {
            obradaVozac.create();
        } catch (MyException ex) {
            System.out.println(ex.getPoruka());
        }
    }
}

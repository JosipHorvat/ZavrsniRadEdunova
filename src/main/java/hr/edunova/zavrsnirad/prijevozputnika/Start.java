package hr.edunova.zavrsnirad.prijevozputnika;

import hr.edunova.horvat.controller.ObradaVozac;
import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.utility.HibernateUtil;
import hr.edunova.horvat.utility.FakerPocetniInsert;
import hr.edunova.horvat.utility.MyException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Josip
 */
public class Start {

    public static void main(String[] args) {
        //  HibernateUtil.getSessionFactory().openSession();
        //  FakerPocetniInsert.izvedi();

        // TEST utf8
       // System.out.println("škola");

        Vozac vozac = new Vozac();

        ObradaVozac obradaVozac = new ObradaVozac(vozac);
        List<Vozac> listaVozaca = new ArrayList<>();
        
        long pocetak = System.currentTimeMillis();
        
        for (int i =0; i<1000; i++){
        vozac = new Vozac();
        vozac.setIme("Tomo");
     
       
        listaVozaca.add(vozac);
             try {
            obradaVozac.createAll(listaVozaca);
        } catch (MyException ex) {
            System.out.println(ex.getPoruka());
        }
        }
       
        long kraj = System.currentTimeMillis();
        
        System.out.println(kraj - pocetak);
        //Prvi test = 40393
        //Drugi test 39893
        //Treci test 37041
    }
}

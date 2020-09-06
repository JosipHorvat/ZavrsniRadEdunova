
package hr.edunova.horvat.utility;

import hr.edunova.horvat.model.Proizvodjac;
import java.util.Date;
import org.hibernate.Session;

/**
 @author Josip
 */
public class FakerPocetniInsert {
    
    public static void izvedi(){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Proizvodjac opel = createProizvodjac("Opel", "Corsa", new Date(), 5, 50);
        Proizvodjac seat = createProizvodjac("Seat", "Ibiza", new Date(), 5, 45);
        Proizvodjac volkswagen = createProizvodjac("Volkswagen", "Golf 2", new Date(), Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        session.beginTransaction();
        session.save(opel);
        session.save(seat);
        session.save(volkswagen);
        session.getTransaction().commit();
    }
    
    private static Proizvodjac createProizvodjac(String naziv, String model, Date datumProizvodnje, Integer brojVrata, Integer kW ){
        Proizvodjac proizvodjac = new Proizvodjac();
        proizvodjac.setNaziv(naziv);
        proizvodjac.setModel(model);
        proizvodjac.setDatumProizvodnje(datumProizvodnje);
        proizvodjac.setBrojVrata(brojVrata);
        proizvodjac.setkW(kW);
        
        return proizvodjac;
    }
}

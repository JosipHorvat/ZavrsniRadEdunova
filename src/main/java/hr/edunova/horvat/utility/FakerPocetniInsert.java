
package hr.edunova.horvat.utility;

import com.github.javafaker.Faker;
import hr.edunova.horvat.controller.ObradaOperater;
import hr.edunova.horvat.model.Operater;
import hr.edunova.horvat.model.Prijevoz;
import hr.edunova.horvat.model.Proizvodjac;
import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.model.Vozilo;
import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.hibernate.Session;
import org.mindrot.jbcrypt.BCrypt;

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
       // session.getTransaction().commit();
    
    
    Faker faker = new Faker();
    
     String[] oibi = {"44879378548","38714462960","48653367511",
            "07463739447","55376858772","57121746664","45088797644","97067197029",
            "36388448333","13633152331"};
     
    
    Vozac vozac;
    Vozilo vozilo;
    Prijevoz prijevoz;
    
    for(int i =0; i<10; i++){
        vozac = new Vozac();
        vozac.setIme(faker.name().firstName());
        vozac.setPrezime(faker.name().lastName());
        vozac.setOib(oibi[i]);
        vozac.setVerificiran(PomocnaMetoda.randomBoolean());
        vozac.setDatumRodjenja(faker.date().birthday(10, 100));
        //vozac.setVozilo();
        session.save(vozac);
        
    }
    for(int i =0; i<10; i++){
        vozilo = new Vozilo();
        vozilo.setBojaVozila(faker.color().name());
        vozilo.setOsiguran(PomocnaMetoda.randomBoolean());
        vozilo.setProizvodjac(volkswagen);
        vozilo.setRegistracijskaOznaka(faker.leagueOfLegends().rank());
        vozilo.setUkupnoPredjenihKm(new BigDecimal(i*10));
        session.save(vozilo);
    }
    for(int i = 0; i<10; i++){
        prijevoz = new Prijevoz();
        prijevoz.setBrojPutnika(faker.random().nextInt(1, 10));
        prijevoz.setCijena(new BigDecimal(i+10));
        prijevoz.setOdrediste(faker.address().fullAddress());
        prijevoz.setPolaziste(faker.address().fullAddress());
        prijevoz.setUkupnoKm(BigDecimal.valueOf(i*15));
       // prijevoz.setVozac(vozac);
       session.save(prijevoz);
        
    }
    
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
    
     public static void unosAdminOperatera(){
       
 //   Admin oper ne treba open session niti commit session jer to odradjuje obrada operatera/
         
        
        Operater operaterAdmin = new Operater();
        operaterAdmin.setIme("Boss");
        operaterAdmin.setPrezime("Bigg");
        operaterAdmin.setUloga("admin");
        operaterAdmin.setEmail("bossadmin@net.hr");
        operaterAdmin.setOib("44879378548");
        operaterAdmin.setLozinka(BCrypt.hashpw("b", BCrypt.gensalt()));
        
        ObradaOperater obradaAdmin = new ObradaOperater();
        obradaAdmin.setEntitet(operaterAdmin);
        
        try{
            obradaAdmin.create();
        }catch (MyException ex){
            ex.printStackTrace();
            
        }
        Operater operater = new Operater();
        operater.setIme("Josip");
        operater.setPrezime("Horvat");
        operater.setUloga("operater");
        operater.setEmail("josiph988@gmail.com");
        operater.setOib("44879378548");
        operater.setLozinka(BCrypt.hashpw("j", BCrypt.gensalt()));
        
        ObradaOperater obradaOperater = new ObradaOperater();
        obradaOperater.setEntitet(operater);
        
         try{
            obradaOperater.create();
        }catch (MyException ex){
            ex.printStackTrace();
        }
        }
}

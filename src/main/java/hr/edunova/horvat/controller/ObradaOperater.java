/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Operater;
import hr.edunova.horvat.utility.MyException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Josip
 */
public class ObradaOperater extends ObradaOsoba<Operater>{
    // dobro obratiti pozornost na ovu metodu
 public  Operater autoriziraj(String email, char[] lozinka){
     
       Operater operater = (Operater) session.createQuery(
       "from Operater o where o.email=:email")
               .setParameter("email", email).getSingleResult();
       
       // ako operater nije pronadjen u bazi vraca se null
       if(operater== null){
           return null;
       }
       // ako je pronadjen u bazi provjeraca se BCrypt da li lozinka odgovara onoj u bazi, a ako ne vraca null
       return BCrypt.checkpw(new String(lozinka), operater.getLozinka()) ? operater : null;
       
 }
 
    @Override
    public List<Operater> getPodaci() {
     return  session.createQuery("from Operater").list();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
        super.kontrolaCreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void kontrolaUpdate() throws MyException {
        super.kontrolaUpdate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void kontrolaDelete() throws MyException {
        super.kontrolaDelete(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Operater;
import hr.edunova.horvat.utility.MyException;
import java.util.List;

/**
 *
 * @author Josip
 */
public class ObradaOperater extends ObradaOsoba<Operater>{
    
// public  Operater autoriziraj(String email, char[] lozinka){
//       Operater operater = (Operater) session.createQuery(
//       "from Operater o where o.email=:email")
//               .setParameter("email", email).getSingleResult();
//       if(operater== null){
//           return null;
//       }
//       return null;
// }

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

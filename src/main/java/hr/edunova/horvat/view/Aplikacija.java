/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.view;

import hr.edunova.horvat.model.Operater;

/**
 *
 * @author Josip
 */
public class Aplikacija {
    
    public static final String NAZIV_APLIKACIJE = "Prijevoz putnika";
    
    public static Operater operater;
    
    public static boolean isAdmin(){
        if(operater==null || operater.getUloga()==null){
            return false;
        }
        return operater.getUloga().equals("admin");
    }
    
}

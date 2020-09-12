/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.utility;

import java.math.BigDecimal;
import java.util.Random;

/**
 *
 * @author Josip
 */
public class PomocnaMetoda {
    
    public static boolean randomBoolean(){
       Random rand = new Random();
       return rand.nextBoolean();
    }
    
     public static void neMozeBitiBroj(String stringVrijednost, String poruka) throws MyException{
       boolean broj = false;
       try{
           new BigDecimal(stringVrijednost);
           broj = true;
       }catch(Exception e){
           }
           if(broj){
               throw new MyException(poruka);
           }
  }   
}

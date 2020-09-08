
package hr.edunova.horvat.utility;

/**
 * @author Josip
 */
public class MyException extends Exception{
    
    private String poruka;
    
    public MyException(String poruka){
        this.poruka=poruka;
    }
    
    
    public String getPoruka(){
        return poruka;
    }
}

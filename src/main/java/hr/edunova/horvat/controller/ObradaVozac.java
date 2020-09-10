
package hr.edunova.horvat.controller;

import hr.edunova.horvat.model.Vozac;
import hr.edunova.horvat.utility.MyException;

/**
 * @author Josip
 */
public class ObradaVozac extends Obrada<Vozac>{
    
    public ObradaVozac(Vozac vozac){
        super(vozac);
    }
    
    public ObradaVozac(){
        super();
    }

    @Override
    protected void kontrolaCreate() throws MyException {
    if(entitet.getIme()== null){
        throw new MyException("Ime nije uneseno.");
    }
    }

    @Override
    protected void kontrolaUpdate() throws MyException {

    }

    @Override
    protected void kontrolaDelete() throws MyException {

    }
    
}

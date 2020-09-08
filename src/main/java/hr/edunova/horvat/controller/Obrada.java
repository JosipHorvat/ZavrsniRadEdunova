/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.edunova.horvat.controller;

import hr.edunova.horvat.utility.HibernateUtil;
import hr.edunova.horvat.utility.MyException;
import org.hibernate.Session;

/**
 *
 * @author Josip
 */
public abstract class Obrada<T> {
    
    protected T entitet;
    protected  Session session;
    
    protected abstract void kontrolaCreate() throws MyException;
    protected abstract void kontrolaUpdate() throws MyException;
    protected abstract void kontrolaDelete() throws MyException;
    
    public Obrada(T entitet){
        this();
        this.entitet = entitet;
    }

public Obrada(){
    this.session=HibernateUtil.getSessionFactory().openSession();
}

public T create() throws MyException{
    kontrolaCreate();
    save();
    return entitet;
}

public T update() throws MyException{
    kontrolaUpdate();
    save();
    return entitet;
}

public boolean delete() throws MyException{
    kontrolaDelete();
    session.beginTransaction();
    session.delete(entitet);
    session.getTransaction().commit();
    return true;
}


private void save(){
    session.beginTransaction();
    session.save(entitet);
    session.getTransaction().commit();
}
}

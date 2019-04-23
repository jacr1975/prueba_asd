/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.dao;

/**
 *
 * @author asus
 */
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pactivosfijos.model.Actfijos;
import com.pactivosfijos.model.Consulta;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;

@Repository("actfijoDao")
public class ActfijoDaoImpl extends AbstractDao<Integer, Actfijos> implements ActfijoDao {

    public Actfijos findBySerial(int serial) {
        Actfijos act = getByKey(serial);

        return act;
    }

    @SuppressWarnings("unchecked")
    public List<Actfijos> findAllActfijo() {
        List<Actfijos> users = getEntityManager()
                .createQuery("SELECT u FROM Actfijos u")
                .getResultList();
        return users;
    }

    @SuppressWarnings("unchecked")
    public List<Actfijos> findConsulta(Consulta cons) {

        String tipo1 = "serial";
        String tipo2 = "tipo";
        String valor = cons.getValor();
        int valor2 = 0;
        
        System.out.println("tipo2  "+cons.getTipo());
        System.out.println("valor2  "+cons.getValor());       

        List<Actfijos> acts = new ArrayList<>();
        
        if (tipo1.equalsIgnoreCase(cons.getTipo())) {
            valor2 = Integer.parseInt(valor);
		try{
			Actfijos act = (Actfijos) getEntityManager()
					.createQuery("SELECT u FROM Actfijos u WHERE u.serial = :ser")
					.setParameter("ser", valor2)
					.getSingleResult();
			
			acts.add(act);
		}catch(NoResultException ex){
			return null;
		}
        } else if(tipo2.equalsIgnoreCase(cons.getTipo())){
            
            		try{
			acts =  getEntityManager()
					.createQuery("SELECT u FROM Actfijos u WHERE u.tipo = :tipo")
					.setParameter("tipo", valor)
					.getResultList();
			
		
		}catch(NoResultException ex){
			return null;
		}
            
        }else{
            		try{
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            
                            
                            Date fc= sdf.parse(valor);
                            
                            try{
                                acts =  getEntityManager()
                                        .createQuery("SELECT u FROM Actfijos u WHERE u.fechacompra = :fc")
                                        .setParameter("fc", fc)
                                        .getResultList();
                                
                                
                            }catch(NoResultException ex){
                                return null;
                            }
                        }catch(ParseException ex){
                Logger.getLogger(ActfijoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
        }

        return acts;
    }

    public void save(Actfijos act) {
        persist(act);
    }

    public void deleteBySerial(int serial) {
        Actfijos act = (Actfijos) getEntityManager()
                .createQuery("SELECT u FROM Actfijos u WHERE u.serial = :ssoId")
                .setParameter("ssoId", serial)
                .getSingleResult();
        delete(act);
    }

}

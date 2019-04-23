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

import com.pactivosfijos.model.Actfijos;
import com.pactivosfijos.model.Consulta;
import java.util.List;

/**
 *
 * @author asus
 */public interface ActfijoDao {		
       
        Actfijos findBySerial(int serial);
	
	void save(Actfijos act);
	
	void deleteBySerial(int serial);
	
        public List<Actfijos> findAllActfijo();
        
        public List<Actfijos> findConsulta(Consulta cons);
	
}


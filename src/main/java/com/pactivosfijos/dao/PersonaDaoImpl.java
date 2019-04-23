/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.dao;


import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pactivosfijos.model.Persona;


@Repository("personaDao")
public class PersonaDaoImpl extends AbstractDao<Integer, Persona> implements PersonaDao {
	
	@SuppressWarnings("unchecked")
	public List<Persona> findAllPersona() {
		List<Persona> users = getEntityManager()
				.createQuery("SELECT u FROM Persona u")
				.getResultList();
		return users;
	}


}

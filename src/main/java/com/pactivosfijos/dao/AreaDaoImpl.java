/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pactivosfijos.model.Area;


@Repository("areaDao")
public class AreaDaoImpl extends AbstractDao<Integer, Area> implements AreaDao {
	
	@SuppressWarnings("unchecked")
	public List<Area> findAllArea() {
		List<Area> users = getEntityManager()
				.createQuery("SELECT u FROM Area u")
				.getResultList();
		return users;
	}


}

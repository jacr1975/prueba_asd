/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.service;

import com.pactivosfijos.dao.PersonaDao;
import com.pactivosfijos.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Service("personaService")
@Transactional
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao dao;

    public List<Persona> findAllPersona() {
        return dao.findAllPersona();
    }

}

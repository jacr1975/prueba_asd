/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.service;

import com.pactivosfijos.model.Persona;
import java.util.List;

/**
 *
 * @author asus
 */
public interface PersonaService {

        List<Persona> findAllPersona();
	
}

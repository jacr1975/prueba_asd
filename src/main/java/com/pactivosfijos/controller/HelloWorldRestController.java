package com.pactivosfijos.controller;

import com.pactivosfijos.model.Actfijos;
import com.pactivosfijos.model.Area;
import com.pactivosfijos.model.Consulta;
import com.pactivosfijos.model.Persona;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.pactivosfijos.service.ActfijoService;
import com.pactivosfijos.service.AreaService;
import com.pactivosfijos.service.PersonaService;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;

@RestController
public class HelloWorldRestController {

    @Autowired
    ActfijoService actFijosService;  //Service which will do all data retrieval/manipulation work

    @Autowired
    AreaService areaService;     
    
    @Autowired
    PersonaService personaService;
    
    @Autowired
    private MessageSource messageSource;

    private static final Logger logger = Logger.getLogger(HelloWorldRestController.class);

    //-------------------Retrieve All Activos Fijos--------------------------------------------------------
    @RequestMapping(value = "/actfijo/", method = RequestMethod.GET)
    public ResponseEntity<List<Actfijos>> listAllActfijos() {
        List<Actfijos> actfijos = actFijosService.findAllActfijo();
        if (actfijos.isEmpty()) {
            return new ResponseEntity<List<Actfijos>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Actfijos>>(actfijos, HttpStatus.OK);
    }

        //-------------------Retrieve All Personas--------------------------------------------------------
    @RequestMapping(value = "/actfijo/listaper", method = RequestMethod.GET)
    public ResponseEntity<List<Persona>> listAllPersonas() {
        List<Persona> personas = personaService.findAllPersona();
        if (personas.isEmpty()) {
            return new ResponseEntity<List<Persona>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
    }
  
        //-------------------Retrieve All Areas--------------------------------------------------------
    @RequestMapping(value = "/actfijo/listaarea", method = RequestMethod.GET)
    public ResponseEntity<List<Area>> listAllAreas() {
        List<Area> areas = areaService.findAllArea();
        if (areas.isEmpty()) {
            return new ResponseEntity<List<Area>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Area>>(areas, HttpStatus.OK);
    }
 
            //-------------------Retrieve Consulta--------------------------------------------------------
    @RequestMapping(value = "/actfijo/listaconsulta/{tipo}/{valor}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Actfijos>> listConsulta(@PathVariable("tipo") String tipo, @PathVariable("valor") String valor) {
     
                System.out.println("tipo  "+tipo);
        System.out.println("valor  "+valor); 
        
        Consulta consulta = new Consulta();
     consulta.setTipo(tipo);
     consulta.setValor(valor);
        List<Actfijos> consulta1 = actFijosService.findConsulta(consulta);
        if (consulta1.isEmpty()) {
            return new ResponseEntity<List<Actfijos>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Actfijos>>(consulta1, HttpStatus.OK);
    }
    
    //-------------------Create a Activo Fijo--------------------------------------------------------
    @RequestMapping(value = "/actfijo/", method = RequestMethod.POST)
    public ResponseEntity<Void> createActfijo(@RequestBody Actfijos act, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Activo Fijo " + act.getNombre());

        actFijosService.saveActfijo(act);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    //------------------- Update a Activo Fijo --------------------------------------------------------
    @RequestMapping(value = "/actfijo/{serial}", method = RequestMethod.PUT)
    public ResponseEntity<Actfijos> updateActFijos(@PathVariable("serial") int serial, @RequestBody Actfijos act) {
        logger.info("Updating Activo Fijo " + serial);

        Actfijos currentAct = actFijosService.findBySerial(serial);

        if (currentAct == null) {
            logger.error("Activo Fifo with serial " + serial + " not found");
            return new ResponseEntity<Actfijos>(HttpStatus.NOT_FOUND);
        }

        currentAct.setSerialNII(act.getSerialNII());
        currentAct.setNombre(act.getNombre());
        currentAct.setDescripcion(act.getDescripcion());
        currentAct.setTipo(act.getTipo());
        currentAct.setPeso(act.getPeso());
        currentAct.setAlto(act.getAlto());
        currentAct.setAncho(act.getAncho());
        currentAct.setLargo(act.getLargo());
        currentAct.setValorcompra(act.getValorcompra());
        currentAct.setFechacompra(act.getFechacompra());
        currentAct.setFechabaja(act.getFechabaja());
        currentAct.setEstadoactual(act.getEstadoactual());
        currentAct.setColor(act.getColor());
        currentAct.setIdPer2(act.getIdPer2());
        currentAct.setIdArea2(act.getIdArea2());

        actFijosService.updateActfijo(currentAct);
        return new ResponseEntity<Actfijos>(currentAct, HttpStatus.OK);
    }

    //------------------- Delete a Activo Fijo --------------------------------------------------------
    @RequestMapping(value = "/actfijo/{serial}", method = RequestMethod.DELETE)
    public ResponseEntity<Actfijos> deleteActFijos(@PathVariable("serial") int serial) {
        logger.info("Fetching & Deleting Activo Fijo with id " + serial);

        Actfijos user = actFijosService.findBySerial(serial);
        if (user == null) {
            logger.error("Unable to delete. Activo Fijo with id " + serial + " not found");
            return new ResponseEntity<Actfijos>(HttpStatus.NOT_FOUND);
        }

        actFijosService.deleteBySerial(serial);
        return new ResponseEntity<Actfijos>(HttpStatus.NO_CONTENT);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.service;

import com.pactivosfijos.dao.ActfijoDao;
import com.pactivosfijos.model.Actfijos;
import com.pactivosfijos.model.Consulta;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Service("actfijoService")
@Transactional
public class ActfijoServiceImpl implements ActfijoService {

    @Autowired
    private ActfijoDao dao;

    public Actfijos findBySerial(int serial) {
        return dao.findBySerial(serial);
    }

    public void saveActfijo(Actfijos act) {
        dao.save(act);
    }

    public void updateActfijo(Actfijos act) {
        Actfijos entity = dao.findBySerial(act.getSerial());
        if (entity != null) {

            entity.setSerialNII(act.getSerialNII());
            entity.setNombre(act.getNombre());
            entity.setDescripcion(act.getDescripcion());
            entity.setTipo(act.getTipo());
            entity.setPeso(act.getPeso());
            entity.setAlto(act.getAlto());
            entity.setAncho(act.getAncho());
            entity.setLargo(act.getLargo());
            entity.setValorcompra(act.getValorcompra());
            entity.setFechacompra(act.getFechacompra());
            entity.setFechabaja(act.getFechabaja());
            entity.setEstadoactual(act.getEstadoactual());
            entity.setColor(act.getColor());
            entity.setIdPer2(act.getIdPer2());
            entity.setIdArea2(act.getIdArea2());
        }
    }

    public void deleteBySerial(int serial) {
        dao.deleteBySerial(serial);
    }

    public List<Actfijos> findAllActfijo() {
        return dao.findAllActfijo();
    }
    
     public List<Actfijos> findConsulta(Consulta cons) {
        return dao.findConsulta(cons);
    }   

}

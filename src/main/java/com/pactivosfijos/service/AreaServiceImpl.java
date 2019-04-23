/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pactivosfijos.service;

import com.pactivosfijos.dao.AreaDao;
import com.pactivosfijos.model.Area;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asus
 */
@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao dao;

    public List<Area> findAllArea() {
        return dao.findAllArea();
    }

}

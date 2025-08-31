package org.nicolly.service;

import java.util.List;

import org.nicolly.model.entity.Airbnb;
import org.nicolly.repository.dao.AirbnbDao;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

@RequestScoped
public class AirbnbService {

    @Inject
    AirbnbDao airbnbDao;

    public List<Airbnb> listar(){
        return airbnbDao.listAll();
    }
}

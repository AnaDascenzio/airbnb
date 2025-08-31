package org.nicolly.repository.dao;

import org.nicolly.model.entity.Airbnb;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AirbnbDao implements PanacheRepositoryBase<Airbnb, Long>{
    
}

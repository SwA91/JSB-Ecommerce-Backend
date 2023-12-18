package com.swa.ecommerce.dao;

import com.swa.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @CrossOrigin("http://localhost:4200") lo tratamos por otro lado
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries") // esta anotacion hace que se exponga la api
public interface CountryRepository extends JpaRepository<Country, Integer> {
    // Country es nuestra entidad
    // Integer es nuestra clave primaria
    // el path es lo que exponemos en la api
}

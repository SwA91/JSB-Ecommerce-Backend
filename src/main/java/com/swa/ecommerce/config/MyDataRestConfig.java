package com.swa.ecommerce.config;

import com.swa.ecommerce.entity.Country;
import com.swa.ecommerce.entity.Product;
import com.swa.ecommerce.entity.ProductCategory;
import com.swa.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ExposureConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entitiyManager;

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entitiyManager = theEntityManager;
    }
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        // RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disabled HTTP methods for Product, ProductCategory: PUT, POST, DELETE
        disabledHttpMethod(Product.class, config, theUnsupportedActions);
        disabledHttpMethod(ProductCategory.class, config, theUnsupportedActions);
        disabledHttpMethod(Country.class, config, theUnsupportedActions);
        disabledHttpMethod(State.class, config, theUnsupportedActions);

        // call an internal helper method
        exposeIds(config);
    }

    private static void disabledHttpMethod(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // expose entity ids

        // get a list of all entitiy clases from the entity manager
        Set<EntityType<?>> entities = entitiyManager.getMetamodel().getEntities();

        // create an array of the entitity types
        ArrayList<Class> entityClasses = new ArrayList<>();

        // get the entity types for the entities
        for(EntityType tempEntityType: entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}

package com.softtek.academy.sboot.util;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module.Feature;

/**
 * Used by MappingJackson2HttpMessageConverter to register additional features and modules required by Jackson to
 * serialize/deserialize data types appropriate
 **/
public class CustomObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;


//    public CustomerObjectMapper() {
//        // Enable the inclusion of properties not annotated with @JsonView() in serializing/deserializing process
//        super.enable(MapperFeature.DEFAULT_VIEW_INCLUSION);
//
//        this.registerHibernateModule();
//    }

    /**
     * Registers Jackson Mapper for handling hibernate lazy loading using Spring 5 MVC, so entities which are lazy
     * declared are now correctly serialized.
     *
     * The following exception will came up in absence of this module:
     * "No serializer found for class org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer" exception.
     */
    private void registerHibernateModule() {
        Hibernate5Module hibernateModule = new Hibernate5Module();
        hibernateModule.enable(Feature.FORCE_LAZY_LOADING);

        super.registerModule(hibernateModule);
    }

}

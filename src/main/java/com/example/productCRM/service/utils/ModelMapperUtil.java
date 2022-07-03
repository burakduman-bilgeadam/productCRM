package com.example.productCRM.service.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//https://www.baeldung.com/java-performance-mapping-frameworks
@Component
public class ModelMapperUtil {
    @Autowired
    private ModelMapper modelMapper;

    public <T,K> T convertToModel(K obje,Class<T> classObject) {
        T convertedObje = modelMapper
                .map(obje, classObject);
        return convertedObje;
    }
}

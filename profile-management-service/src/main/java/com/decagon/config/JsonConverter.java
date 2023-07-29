package com.decagon.config;

import com.decagon.domain.pojo.ContactInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JsonConverter implements AttributeConverter<Object, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            // Handle exception or log error
            return null;
        }
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        try {
            // Change Object to the specific target class (e.g., ContactInformation)
            return objectMapper.readValue(dbData, ContactInformation.class);
        } catch (Exception e) {
            // Handle exception or log error
            return null;
        }
    }
}

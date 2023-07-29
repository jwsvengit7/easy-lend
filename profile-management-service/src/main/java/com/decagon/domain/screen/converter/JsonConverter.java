package com.decagon.domain.screen.converter;

import com.decagon.domain.screen.*;
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
            // Deserialize the JSON data to ContactInformation if possible
            try {
                return objectMapper.readValue(dbData, ContactInformation.class);
            } catch (Exception e) {
                // If it's not ContactInformation, try deserializing as GovernmentID
                try {
                    return objectMapper.readValue(dbData, GovernmentID.class);
                } catch (Exception ex1) {
                    // If it's not GovernmentID, try deserializing as IncomeStatus
                    try {
                        return objectMapper.readValue(dbData, IncomeStatus.class);
                    } catch (Exception ex2) {
                        // If it's not IncomeStatus, try deserializing as ProofOfAddress
                        try {
                            return objectMapper.readValue(dbData, ProofOfAddress.class);
                        } catch (Exception ex3) {
                            // If it's not ProofOfAddress, try deserializing as BankAccount
                            try {
                                return objectMapper.readValue(dbData, BankAccount.class);
                            } catch (Exception ex4) {
                                // If it's not BankAccount, try deserializing as EmploymentStatus
                                try {
                                    return objectMapper.readValue(dbData, EmploymentStatus.class);
                                } catch (Exception ex5) {
                                    // Handle exception or log error for any unknown class
                                    return null;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            // Handle exception or log error
            return null;
        }
    }
}
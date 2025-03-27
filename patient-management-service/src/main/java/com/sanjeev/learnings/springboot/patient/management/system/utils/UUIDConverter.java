package com.sanjeev.learnings.springboot.patient.management.system.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, String> {

    @Override
    public String convertToDatabaseColumn(UUID uuid) {
        return (uuid == null) ? null : uuid.toString();
    }

    @Override
    public UUID convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : UUID.fromString(dbData);
    }
}

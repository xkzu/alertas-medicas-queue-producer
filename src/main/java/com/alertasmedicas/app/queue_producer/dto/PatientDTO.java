package com.alertasmedicas.app.queue_producer.dto;

public record PatientDTO (
        Long id,
        Long idDoctor,
        String name,
        String state
) {}
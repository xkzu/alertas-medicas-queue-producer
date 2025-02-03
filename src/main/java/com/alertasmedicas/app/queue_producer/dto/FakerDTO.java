package com.alertasmedicas.app.queue_producer.dto;

import java.util.List;

public record FakerDTO (
        PatientDTO patient,
        List<MeasurementDTO> measurements
) {}
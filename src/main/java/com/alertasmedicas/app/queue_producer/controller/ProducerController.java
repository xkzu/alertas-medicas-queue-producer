package com.alertasmedicas.app.queue_producer.controller;

import com.alertasmedicas.app.queue_producer.dto.FakerDTO;
import com.alertasmedicas.app.queue_producer.dto.MeasurementDTO;
import com.alertasmedicas.app.queue_producer.service.ProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/queue")
public class ProducerController {

    private final ProducerService producerService;

    @Autowired
    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send/anomaly")
    public ResponseEntity<String> sendAnomaly(@RequestBody MeasurementDTO measurementDTO) {
        log.info("Enviando anomalias measurementDTO: {}", measurementDTO);
        try {
            producerService.sendMessageAnomaly(measurementDTO);
            return ResponseEntity.ok("Mensaje enviado");
        } catch (Exception e) {
            log.info("Error al enviar anomalias: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @PostMapping("/send/pacientMeasures")
    public ResponseEntity<String> sendVitalsSigns(@RequestBody List<FakerDTO> fakerList) {
        log.info("Enviando signos vitales fakerDTO: {}", fakerList);
        try {
            producerService.sendMessageVitalsSigns(fakerList);
            return ResponseEntity.ok("Mensaje enviado");
        } catch (Exception e) {
            log.info("Error al enviar signos vitales: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

}

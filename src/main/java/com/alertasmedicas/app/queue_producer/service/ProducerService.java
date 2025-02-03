package com.alertasmedicas.app.queue_producer.service;

import com.alertasmedicas.app.queue_producer.dto.MeasurementDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.queue.name}")
    private String queueName;

    @Value("${rabbitmq.queue.name2}")
    private String queueVitalsSigns;

    @Autowired
    public ProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(MeasurementDTO measurementDTO) {
        this.rabbitTemplate.convertAndSend(queueName, measurementDTO.toString());
    }
}

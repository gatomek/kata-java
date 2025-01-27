package pl.gatomek.producer;


import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ScheduledTransmitter {

    private final JmsTemplate jmsTemplate;

    public ScheduledTransmitter( JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled( fixedDelay = 1000)
    public void transmit() {
        try {
            jmsTemplate.send("uuid",session -> session.createTextMessage(UUID.randomUUID().toString()));
        }
        catch (JmsException ex) {
            System.out.println( ex.getMessage());
        }
    }
}

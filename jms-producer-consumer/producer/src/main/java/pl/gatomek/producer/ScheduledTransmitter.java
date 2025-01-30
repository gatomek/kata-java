package pl.gatomek.producer;


import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import pl.gatomek.lib.Message;

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
            Message msg = new Message();
            msg.setUuid( UUID.randomUUID());
            System.out.println( "Producing: " + msg.getUuid());

            jmsTemplate.convertAndSend( "uuid", msg);
        }
        catch (JmsException ex) {
            System.out.println( ex.getMessage());
        }
    }
}

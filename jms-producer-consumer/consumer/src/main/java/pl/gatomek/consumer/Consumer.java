package pl.gatomek.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import pl.gatomek.lib.Message;

@Component
public class Consumer {

    @JmsListener( destination = "uuid", containerFactory = "listenerContainerFactory")
    public void consume( Message msg) {
        System.out.println( "Receiving: " + msg.getUuid());
    }
}

package pl.gatomek.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Consumer {

    @JmsListener( destination = "uuid")
    public void consume( UUID uuid) {
        System.out.println( "Receiving: " + uuid);
    }
}

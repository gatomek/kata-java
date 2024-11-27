package pl.gatomek.SimpleApp;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class Worker {

    @Scheduled( fixedDelayString="${scheduled.fix-delay}")
    public static void calculate() {
        log.atInfo().log( "uuid: {}", UUID.randomUUID());
    }
}

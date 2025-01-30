package pl.gatomek.consumer;

import jakarta.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MessageConverter;

@Profile( "!topic")
@Configuration
public class ConfigQueueJmsListener {

    @Bean
    public JmsListenerContainerFactory<?> listenerContainerFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            MessageConverter messageConverter)
    {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure( factory, connectionFactory);
        factory.setConcurrency( "1");
        factory.setMessageConverter(messageConverter);
        return factory;
    }
}

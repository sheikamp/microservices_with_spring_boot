package microservices.book.multiplication.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

/**
 * Configures JMS to use events in our application.
 */
@Configuration
@EnableJms
public class JmsConfiguration {

    @Bean
    public MessageConverter consumerJackson2MessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTypeIdPropertyName("Type ID");
        return converter;
    }

}
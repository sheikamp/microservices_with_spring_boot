package microservices.book.multiplication.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * Handles the communication with the Event Bus.
 */
@Component
public class EventDispatcher {

    private final JmsTemplate jmsTemplate;

    private final String queue;

    @Autowired
    EventDispatcher(final JmsTemplate jmsTemplate, @Value("${multiplication.queue}") final String queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public void send(final MultiplicationSolvedEvent multiplicationSolvedEvent) {
        jmsTemplate.convertAndSend(queue, multiplicationSolvedEvent);
    }
}
package microservices.book.gamification.event;

import lombok.extern.slf4j.Slf4j;
import microservices.book.gamification.service.GameService;
import microservices.book.multiplication.event.MultiplicationSolvedEvent;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * This class receives the events and triggers the associated
 * business logic.
 */
@Slf4j
@Component
class EventHandler {

    private GameService gameService;

    EventHandler(final GameService gameService) {
        this.gameService = gameService;
    }

    @JmsListener(destination = "${multiplication.queue}")
    void handleMultiplicationSolved(final MultiplicationSolvedEvent event) {
        log.info("Multiplication Solved Event received: {}", event.getMultiplicationResultAttemptId());
        try {
            gameService.newAttemptForUser(event.getUserId(),
                    event.getMultiplicationResultAttemptId(),
                    event.isCorrect());
        } catch (final Exception e) {
            log.error("Error when trying to process MultiplicationSolvedEvent", e);
            // Avoids the event to be re-queued and reprocessed.
            throw new IllegalArgumentException(e);
        }
    }
}
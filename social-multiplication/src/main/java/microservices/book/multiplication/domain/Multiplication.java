package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * This class represents a Multiplication (a * b).
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class Multiplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    // Both factors
    private final int factorA;
    private final int factorB;

    // Empty constructor for JSON (de)serialization / JPA
    Multiplication() {
        this(0, 0);
    }
}
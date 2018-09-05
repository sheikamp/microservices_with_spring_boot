package microservices.book.multiplication.repository;

import microservices.book.multiplication.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {

    Optional<Multiplication> findByFactorAAndFactorB(final int factorA, final int factorB);
}

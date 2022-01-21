package pl.zadanie.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zadanie.credit.model.Credit;

public interface CreditRepository extends JpaRepository<Credit,Integer> {
}

package ru.Edje_7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.Edje_7.model.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, String> {

}

package ru.Edje_7.model;


import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    private String id;
    private String name;
    private String baseCurrency;
    private String priceChangeRange;
    private String description;

}

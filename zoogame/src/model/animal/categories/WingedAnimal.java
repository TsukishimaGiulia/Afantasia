package model.animal.categories;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class WingedAnimal extends Animal {

    private Double wingspan;

    protected WingedAnimal(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double wingspan) {
        super(name, favoriteFood, age, dateOfEntry, weight, height);
        this.wingspan = wingspan;
    }
}

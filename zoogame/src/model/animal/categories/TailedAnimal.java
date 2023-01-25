package model.animal.categories;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class TailedAnimal extends Animal {

    private Double tailLength;

    protected TailedAnimal(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double tailLength) {
        super(name, favoriteFood, age, dateOfEntry, weight, height);
        this.tailLength = tailLength;
    }
}

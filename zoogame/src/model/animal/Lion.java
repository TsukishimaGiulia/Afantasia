package model.animal;

import model.animal.categories.TailedAnimal;

import java.time.LocalDate;

public class Lion extends TailedAnimal {


    public Lion(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double tailLength) {
        super(name, favoriteFood, age, dateOfEntry, weight, height, tailLength);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + this.getName();
    }
}

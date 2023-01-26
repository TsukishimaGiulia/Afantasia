package model.animal;

import model.animal.categories.TailedAnimal;

import java.time.LocalDate;

public class Monkey extends TailedAnimal {

    public Monkey(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double tailLength) {
        super(name, favoriteFood, age, dateOfEntry, weight, height, tailLength);
    }
}

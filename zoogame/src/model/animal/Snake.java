package model.animal;

import model.animal.categories.CrawlingAnimal;

import java.time.LocalDate;

public class Snake extends CrawlingAnimal {

    public Snake(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height) {
        super(name, favoriteFood, age, dateOfEntry, weight, height);
    }
}

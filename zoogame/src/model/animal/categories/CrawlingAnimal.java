package model.animal.categories;

import java.time.LocalDate;

public abstract class CrawlingAnimal extends Animal{

    public CrawlingAnimal(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height) {
        super(name, favoriteFood, age, dateOfEntry, weight, height);
    }
}

package model;

import model.categories.WingedAnimal;

import java.time.LocalDate;

public class Eagle extends WingedAnimal {

    public Eagle(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double wingspan) {
        super(name, favoriteFood, age, dateOfEntry, weight, height, wingspan);
    }


}

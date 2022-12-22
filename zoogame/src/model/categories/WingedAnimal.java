package model.categories;

import java.time.LocalDate;

public abstract class WingedAnimal extends Animal {

    private Double wingspan;

    public WingedAnimal(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height, Double wingspan) {
        super(name, favoriteFood, age, dateOfEntry, weight, height);
        this.wingspan = wingspan;
    }

    public Double getWingspan() {
        return wingspan;
    }

    public void setWingspan(Double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "AnimalWithWings{" +
                "name=" + super.getName() + " " +
                "weight" + super.getWeight() + " " +
                "height" + super.getHeight() + " " +
                "wingspan=" + wingspan +
                '}';
    }
}
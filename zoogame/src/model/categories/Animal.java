package model.categories;

import java.time.LocalDate;

public abstract class Animal {

    private String name;
    private String favoriteFood;
    private Integer age;
    private LocalDate dateOfEntry;
    private Double weight;
    private Double height;

    public Animal(String name, String favoriteFood, Integer age, LocalDate dateOfEntry, Double weight, Double height) {
        this.name = name;
        this.favoriteFood = favoriteFood;
        this.age = age;
        this.dateOfEntry = dateOfEntry;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                ", age=" + age +
                ", dateOfEntry=" + dateOfEntry +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}

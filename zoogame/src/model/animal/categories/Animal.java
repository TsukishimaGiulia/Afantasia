package model.animal.categories;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
@Getter
public abstract class Animal {

    private String name;
    private String favoriteFood;
    private Integer age;
    private LocalDate dateOfEntry;
    private Double weight;
    private Double height;

    public String simpleDescription() {
        return this.getClass().getSimpleName() + " " + this.getName();
    }
}

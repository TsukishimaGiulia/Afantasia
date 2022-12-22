package animal.model;


import animal.model.categories.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {

    private Map<Class<? extends Animal>, List<Animal>> animalMap = new HashMap<>();

    public void initialize(){
        List<Animal> eagles = new ArrayList<>();
        List<Animal> tigers = new ArrayList<>();
        List<Animal> lions = new ArrayList<>();

        eagles.add(new Eagle("Mar", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Ika", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Mir", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));

        lions.add(new Lion("Mar", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Mar", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Mar", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));

        tigers.add(new Tiger("TigreMar", "pizza", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("TigreMar", "pizza", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("TigreMar", "pizza", 22, LocalDate.now(), 3.6,3.8, 1.8));

        animalMap.put(Eagle.class, eagles);
        animalMap.put(Lion.class, lions);
        animalMap.put(Tiger.class, tigers);
    }

    public Map<Class<? extends Animal>, List<Animal>> getAnimalMap() {
        return animalMap;
    }

    public void addAnimal (Animal animal){
        List <Animal> animals = animalMap.putIfAbsent(animal.getClass(), new ArrayList<>());
        animals.add(animal);
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animalMap=" + animalMap +
                '}';
    }
}

package model.animal;


import model.animal.categories.Animal;

import java.time.LocalDate;
import java.util.*;

public class Zoo {

    private Map<Class<? extends Animal>, List<Animal>> animalMap = new HashMap<>();

    public void initialize(){
        List<Animal> eagles = new ArrayList<>();
        List<Animal> tigers = new ArrayList<>();
        List<Animal> lions = new ArrayList<>();

        eagles.add(new Eagle("Murkrow", "baccananas", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Donatello", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Raffaello", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));

        lions.add(new Lion("Leonardo", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Alex", "bistecche", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Simba", "croccantini", 22, LocalDate.now(), 3.6,3.6, 1.8));

        tigers.add(new Tiger("Tigro", "miele", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("Sherekhan", "gazzelle", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("Torakiki", "frittelle", 22, LocalDate.now(), 3.6,3.8, 1.8));


        animalMap.put(Eagle.class, eagles);
        animalMap.put(Lion.class, lions);
        animalMap.put(Tiger.class, tigers);
    }

    public Map<Class<? extends Animal>, List<Animal>> getAnimalMap() {
        return animalMap;
    }

    public List<Animal> getAllAnimals(){
        initialize();
        Set<Class<? extends Animal>> classes = getAnimalMap().keySet();
        List<Animal> animals = new ArrayList<Animal>();
        for(Class c : classes){
            animals.addAll(getAnimalMap().get(c));
        }
        return animals;
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

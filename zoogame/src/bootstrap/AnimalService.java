package bootstrap;


import lombok.Getter;
import model.animal.*;
import model.animal.categories.Animal;

import java.time.LocalDate;
import java.util.*;

public class AnimalService {

    @Getter
    private Map<Class<? extends Animal>, List<Animal>> animalMap = new HashMap<>();

    public void initialize(){
        List<Animal> eagles = new ArrayList<>();
        List<Animal> tigers = new ArrayList<>();
        List<Animal> lions = new ArrayList<>();
        List<Animal> giraffes = new ArrayList<>();
        List<Animal> monkeys = new ArrayList<>();
        List<Animal> snakes = new ArrayList<>();

        eagles.add(new Eagle("Murkrow", "baccananas", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Donatello", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        eagles.add(new Eagle("Raffaello", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));

        lions.add(new Lion("Leonardo", "pizza", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Alex", "bistecche", 22, LocalDate.now(), 3.6,3.6, 1.8));
        lions.add(new Lion("Simba", "croccantini", 22, LocalDate.now(), 3.6,3.6, 1.8));

        tigers.add(new Tiger("Tigro", "miele", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("Sherekhan", "gazzelle", 22, LocalDate.now(), 3.6,3.8, 1.8));
        tigers.add(new Tiger("Torakiki", "frittelle", 22, LocalDate.now(), 3.6,3.8, 1.8));

        giraffes.add(new Giraffe("Melman","aspirina", 22, LocalDate.now(),3.7,3.8,1.8));
        giraffes.add(new Giraffe("Girafarig","baccaperina", 22, LocalDate.now(),3.7,3.8,1.8));
        giraffes.add(new Giraffe("Genoveffa","foglie", 22, LocalDate.now(),3.7,3.8,1.8));

        monkeys.add(new Monkey("Goku","nunSeButtaViaGnente", 22, LocalDate.now(),3.7,3.8,1.8));
        monkeys.add(new Monkey("George","banane", 22, LocalDate.now(),3.7,3.8,1.8));
        monkeys.add(new Monkey("KoKo","zuppa", 22, LocalDate.now(),3.7,3.8,1.8));

        snakes.add(new Snake("Sir Biss","caramelle", 22, LocalDate.now(),3.7,3.8));
        snakes.add(new Snake("Seviper","baccaki", 22, LocalDate.now(),3.7,3.8));
        snakes.add(new Snake("Nagini","mezzosangue", 22, LocalDate.now(),3.7,3.8));

        animalMap.put(Eagle.class, eagles);
        animalMap.put(Lion.class, lions);
        animalMap.put(Tiger.class, tigers);
        animalMap.put(Giraffe.class, giraffes);
        animalMap.put(Monkey.class, monkeys);
        animalMap.put(Snake.class, snakes);
    }

    public List<Animal> getAllAnimals(){
        initialize();
        Set<Class<? extends Animal>> classes = getAnimalMap().keySet();
        List<Animal> animals = new ArrayList<>();
        for(Class c : classes){
            animals.addAll(getAnimalMap().get(c));
        }
        return animals;
    }

    public void addAnimal (Animal animal){
        List <Animal> animals = animalMap.putIfAbsent(animal.getClass(), new ArrayList<>());
        animals.add(animal);
    }
}

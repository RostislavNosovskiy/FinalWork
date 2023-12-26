package Servise;

import java.time.LocalDate;
import java.util.Date;

public class AnimalCreator {
    private static int id=1;
public Animal CreateAnimal(Type type, String name, LocalDate bornDate){
Animal animal = CreateNewAnimal(type);
animal.SetName(name);
animal.SetbornDate(bornDate);
animal.SetId(id);
id++;
return animal;
}

public Animal CreateNewAnimal(Type type){
    switch (type){
        case Cat:
            return new Cat();
        case Dog:
            return new Dog();
        case Hamster:
            return new Hamster();
        case Horse:
            return new Horse();
        case Camel:
            return new Camel();
        case Donkey:
            return new Donkey();
    }
    return null;
}
}

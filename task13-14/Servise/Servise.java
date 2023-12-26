package Servise;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static Servise.Type.getType;

public class Servise {
    private List<Animal> animalList;

    public Servise(){
this.animalList = new ArrayList<>();
    }

    public String showAllAnimals(){
        StringBuilder res = new StringBuilder();
        if(this.animalList.size()==0){
            res.append("Питомник пустой");
        }else{
        for(Animal animal: animalList){
            res.append(animal.toString());
            res.append("\n");
        }}
        return res.toString();
    }
    public String addNewAnimal(Scanner scanner) throws InputMismatchException, NullPointerException, DateTimeException {
        AnimalCreator creator = new AnimalCreator();
        System.out.println("Выберете вид нового питомца (для этого введите id животного):" +"\n"+
                "1.Кошка" +"\n"+
                "2.Собака" +"\n"+
                "3.Хомяк" +"\n"+
                "4.Лошадь" +"\n"+
                "5.Верблюд" +"\n"+
                "6.Осёл");
        int typeId = scanner.nextInt();
        System.out.println("Введите имя животного:");
        String name = scanner.next();
        System.out.println("Введите год рождения животного:");
        int year = scanner.nextInt();
        System.out.println("Введите месяц рождения животного:");
        int mounth = scanner.nextInt();
        System.out.println("Введите день рождения животного:");
        int day = scanner.nextInt();
        Type type = getType(typeId);
        Animal animal = creator.CreateAnimal(type, name, LocalDate.of(year, mounth, day));
this.animalList.add(animal);
return "Вы успешно добавили животное: " + animal.toString();
    }

    public String showAllAnimalsCommand(Scanner scanner){
        if(this.animalList.size()==0){
            return "Питомник пустой, добавьте новое животное и обучите его комнадам";
        }
        Animal animal = this.findForId(scanner);
        if(animal==null){
            return "Животное с данным индексом не найдено";
        }
        if(animal.commands.toString().equals("")){
            return "Животное не обучено командам";}
return  animal.toString() + " умеет выполнять следующие команды: \n" + animal.commands.toString();
    }

    public String addNewCommand(Scanner scanner){
        if(this.animalList.size()==0){
            return "Питомник пустой, добавьте новое животное и обучите его комнадам";
        }
        Animal animal = this.findForId(scanner);
        if(animal==null){
            return "Животное с данным индексом не найдено";
        }
        System.out.println( "Вы выбрали животное: " + animal);
        System.out.println("Введите назавние изучаемой им команды");
        String commandName = scanner.next();
        System.out.println("Введите описание изучаемой им команды");
        String commandDescription = scanner.next();
        Command command = new Command(commandName, commandDescription);
        animal.commands.addCommand(command);
        return "Животное: " + animal.toString() + "\nИзучило новую команду:" + command.toString();
    }

    public Animal findForId(Scanner scanner){
        System.out.println(this.showAllAnimals());
        System.out.println("Введтите id животного, чтобы увидеть список всех выполняемых им команд:");
        int id = scanner.nextInt();
        for(Animal animal: this.animalList){
            if(animal.getId()==id){
                return animal;
            }
        }
        return null;
    }



}

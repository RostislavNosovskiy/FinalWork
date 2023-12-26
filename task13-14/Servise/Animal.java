package Servise;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public abstract class Animal {
    protected int id;
    protected String animalName;
    protected LocalDate bornDate;
    protected AnimalCommand commands;

    public String getAnimalName(){
        return this.animalName;
    }
    public void SetName(String animalName){
        this.animalName = animalName;
    }
    public void SetbornDate(LocalDate bornDate){
        this.bornDate = bornDate;
    }


    public void SetId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }

    public String toString(){
        return "id: " + this.id + ", имя питомца: " + this.animalName + ", дата рождения: " + this.bornDate.toString();
    }








}

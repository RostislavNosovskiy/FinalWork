package Presenter;

import Servise.Servise;
import View.View;

import java.security.Provider;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Presenter {
    private  View view;
    private Servise servise;

    public Presenter(View view){
        this.view = view;
        this.servise = new Servise();
    }

    public String showAllAnimals() throws InputMismatchException, NullPointerException, DateTimeException {
        return servise.showAllAnimals();
    }

    public String addAnimal (Scanner scanner) throws InputMismatchException, NullPointerException{
        return servise.addNewAnimal(scanner);
    }

    public String showAllAnimalsCommand(Scanner scanner){return servise.showAllAnimalsCommand(scanner);}

    public String addNewCommand (Scanner scanner){return  servise.addNewCommand(scanner);}
}

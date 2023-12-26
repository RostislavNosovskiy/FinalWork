package View;

import Presenter.Presenter;

import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class ConsoleUI implements  View{
    public Scanner scanner;
    public Presenter presenter;
    String menu = "Выберите действие:" +"\n"+
            "1.Показать всех питомцев"+"\n"+
            "2.Добавить новго питомца"+"\n"+
            "3.Показать список всех команд, выполняемых питомцем" +"\n"+
            "4.Обучить питомца новой команде" +"\n"+
            "5.Завершить работу программы";

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter(this);
    }

    @Override
    public void start() {
        boolean programWork = true;
        while (programWork)
        {
            System.out.println(menu);
            int choise = scanner.nextInt();
            switch (choise){
                case 1:
                    printAnswer(presenter.showAllAnimals());
                    break;
                case 2:
                    try {
                    printAnswer(presenter.addAnimal(scanner));
                    }catch (NullPointerException e){
                        printAnswer("Некорректное значение id животного");
                    }catch (DateTimeException | InputMismatchException e){
                        printAnswer("Некорреьтные значения введённой даты");
                    }
                    break;
                case 3:
                    printAnswer(presenter.showAllAnimalsCommand(scanner));
                    break;
                case 4:
                    printAnswer(presenter.addNewCommand(scanner));
                    break;
                case 5:
                    programWork = false;
                    break;
                default:
                    printAnswer("Некорректная комманда");
            }

        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}

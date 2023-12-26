package Servise;

import java.util.ArrayList;

public class AnimalCommand {
    private ArrayList<Command> animalCommand;

    public AnimalCommand(){
        this.animalCommand = new ArrayList<>();
    }

    public void addCommand(Command command){
        this.animalCommand.add(command);
    }

    public String toString(){
        StringBuilder res = new StringBuilder();
        for (Command command: animalCommand){
            res.append(command);
            res.append("\n");
        }
        return res.toString();
    }

}

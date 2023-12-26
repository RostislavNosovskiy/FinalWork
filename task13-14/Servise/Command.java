package Servise;

public class Command {
    private String commandName;
    private String commandDescription;
    public Command(String name, String description ){
        this.commandName = name;
        this.commandDescription = description;
    }
    public Command(String name){
        this(name, "Команда не имеет описания");
    }
    public String getCommandName(){
        return this.commandName;
    }
    public String getCommandDescription(){
        return this.commandDescription;
    }
    public void setCommandDescription(String commandDescription){
        this.commandDescription = commandDescription;
    }

    public String toString(){
        return  this.commandName + ", описание команды: " + this.commandDescription;
    }
}

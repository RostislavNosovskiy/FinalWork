package Servise;

public class Dog extends PackAnimal{
public Dog(){
    this.commands = new AnimalCommand();
    Command command = new Command("Голос!");
    this.commands.addCommand(command);
}
}

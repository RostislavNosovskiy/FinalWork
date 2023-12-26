package Servise;

public enum Type {
    Cat, Dog, Hamster, Horse, Camel, Donkey;

    public  static Type getType(int typeid){
        switch (typeid){
            case 1:
                return Type.Cat;
            case 2:
                return Type.Dog;
            case 3:
                return Type.Hamster;
            case 4:
                return Type.Horse;
            case 5:
                return Type.Camel;
            case 6:
                return Type.Donkey;
            default:
                return null;

        }
    }

}

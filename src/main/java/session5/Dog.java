package session5;

public class Dog extends Animal {

    private String color;

    public Dog(String color, int age, String name) {
        super(age, name);
        this.color = color;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("white", 3, "gogo");
        System.out.println(dog);
    }

}

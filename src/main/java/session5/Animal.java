package session5;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Animal {
    private int age;
    private String name;
    private String color;

    public Animal (int age, String name) {
        System.out.println("Animal constructor");
        this.age = age;
        this.name = name;
    }

    public static void move() {
        System.out.println("move");
    }

    public void jump() {
        System.out.println("jump");
    }

    public void run() {
        this.jump();
    }

    public Animal constructAge(int age) {
        this.setAge(age);
        return this;
    }

    public Animal constructName(String name) {
        this.setName(name);
        return this;
    }

    public Animal constructColor(String color) {
        this.setColor(color);
        return this;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.constructAge(10).constructName("Gogo").constructColor("black");
        System.out.println(animal);
    }
}


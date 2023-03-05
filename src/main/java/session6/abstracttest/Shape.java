package session6.abstracttest;

import lombok.Data;

@Data
public abstract class Shape {
    private String color;
    public abstract double calPerimeter();

    public abstract String getType();

    public Shape() {}
    public Shape(String color) {
        this.color = color;
    }
}

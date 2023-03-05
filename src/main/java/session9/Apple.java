package session9;

public class Apple<T> {
    private T info;
    public Apple() {}
    public Apple(T info) {
        this.info = info;
    }
    public void setInfo(T info) {
        this.info = info;
    }
    public T getInfo() {
        return this.info;
    }
}

class A<T> extends Apple<T> {
    public A() {
        System.out.println("i can");
    }
}

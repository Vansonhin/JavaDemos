package session7;

import lombok.Data;


public class User implements Cloneable {
    int age;
    public User(int age) {
        this.age = age;
    }
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User(12);
        User u2 = u1.clone();
        System.out.println(u1 == u2); // false!!!
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
        System.out.println(u1.equals(u2));
    }
}

package session5;

/**
 * 继承表达的是一种“是(is a)”的关系，而组合表达的是一种“有(has a)”的关系
 */
class DongWu {
    private void beat() {
        System.out.println("心脏跳动");
    }

    public void breathe() {
        beat();
        System.out.println("呼吸中");
    }
}

class Bird {
    private final DongWu dongWu;

    public Bird(DongWu dongWu) {
        this.dongWu = dongWu;
    }

    public void breathe() {
        dongWu.breathe();
    }

    public void fly() {
        System.out.println("飞");
    }
}

public class CompositeTest {
    public static void main(String[] args) {
        DongWu d1 = new DongWu();
        Bird bird = new Bird(d1);
        bird.breathe();
        bird.fly();
    }
}

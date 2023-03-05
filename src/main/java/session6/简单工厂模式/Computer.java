package session6.简单工厂模式;

import session6.interfaceTest.Output;

public class Computer {
    private Output output;
    public Computer(Output output) {
        this.output = output;
    }

    public void keyIn(String msg) {
        output.getData(msg);
    }

    public void print() {
        output.out();
    }
}

package session6.简单工厂模式;

import session6.interfaceTest.Output;
import session6.interfaceTest.Printer;

public class OutputFactory {
    /**
     * 如果将来需要换BetterPrinter，也就只需要新增类然后在这里改下代码就ok啦
     */
    public Output getOutput() {
        return new Printer();
    }

    public static void main(String[] args) {
        OutputFactory factory = new OutputFactory();
        Computer computer = new Computer(factory.getOutput());
        computer.keyIn("abc");
        computer.keyIn("def");
        computer.print();
    }
}

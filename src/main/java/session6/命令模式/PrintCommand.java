package session6.命令模式;

public class PrintCommand implements Command {

    @Override
    public void process(int element) {
        System.out.println("输出: " + element);
    }
}

package session6.命令模式;

public class SquareCommand implements Command {

    @Override
    public void process(int element) {
        System.out.println("数组元素的平方是：" + Math.pow(element, 2));
    }
}

package session6.命令模式;

public class CommandTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] arr = new int[]{15, 33, 999, 888};
//        pa.process(arr, new PrintCommand());
        pa.process(arr, new Command() {
            @Override
            public void process(int element) {
                System.out.println("输出: " + element);
            }
        });
//        pa.process(arr, new SquareCommand());
        pa.process(arr, element -> System.out.println("数组元素的平方是：" + Math.pow(element, 2)));
    }
}

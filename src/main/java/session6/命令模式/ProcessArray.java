package session6.命令模式;

public class ProcessArray {
    public void process(int[] arr, Command command) {
        for (int i : arr) {
            command.process(i);
        }
    }
}

package moban;

import java.math.BigDecimal;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BankBusinessHandler {
    public final void execute(Supplier<String> supplier, Consumer<BigDecimal> consumer) {
        String number = supplier.get();
        System.out.println(number);
        if (number.startsWith("vip")) {
            System.out.println("Assign To Vip Counter");
        } else {
            System.out.println("Assign To Usual Counter");
        }
        consumer.accept(null);
        judge();
    }

    private void judge() {
        System.out.println("give a praised");
    }

    public void save(BigDecimal amount) {
        execute(() -> "number-00" + new Random().nextInt(10000), bigDecimal -> System.out.println("save " + amount));
    }

    public void vipSave(BigDecimal amount) {
        execute(() -> "vipNumber-00" + new Random().nextInt(1000), bigDecimal -> System.out.println("save" + amount));
    }

//    public void draw(BigDecimal amount) {
//        execute(bigDecimal -> System.out.println("draw " + amount));
//    }

    public static void main(String[] args) {
        BankBusinessHandler handler = new BankBusinessHandler();
        handler.save(new BigDecimal(1000));
        handler.vipSave(new BigDecimal(2000));
    }
}

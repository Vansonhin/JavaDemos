package session14;

import java.lang.reflect.Method;

public class ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        for (Method method : Class.forName(clazz).getMethods()) {
            if (method.isAnnotationPresent(Testable.class)) {
                try {
                    method.invoke(null);
                    passed++;
                } catch (Exception e) {
                    System.out.println("方法" + method + "运行失败，异常：" + e.getCause());
                    failed++;
                }
            }
        }
        System.out.println("共运行了" + (passed + failed) + "个方法，其中：" + "失败了" + failed + "个，成功了" + passed + "个");
    }
}

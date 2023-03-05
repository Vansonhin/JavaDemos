package session14;

import java.lang.annotation.*;

//@Retention(RetentionPolicy.SOURCE) // 注解只保留在源代码中，编译器直接丢弃这种注解
//@Retention(RetentionPolicy.CLASS) // 默认值，当运行Java程序时，JVM不可获取注解信息
@Retention(RetentionPolicy.RUNTIME) // 当运行Java程序时，JVM也可以获取注解信息，程序可以通过反射来获取该注解信息
@Target(ElementType.METHOD)
public @interface TestTable {
    String name() default "Vanson";
    int age() default 26;
}

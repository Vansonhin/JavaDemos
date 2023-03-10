package session18reflect;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class ClassLoaderPropTest {
    public static void main(String[] args) throws IOException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器: " + systemClassLoader);
        // 获取类加载器的加载路径————通常由classpath环境变量指定，如果操作系统没有指定该环境变量，则默认以当前路径作为类加载器的加载路径
        Enumeration<URL> resources = systemClassLoader.getResources("");
        while (resources.hasMoreElements()) {
            // 因为加载路径是这样，所以加载类的时候需要用 包.类名 这样的全限定名来指定是哪个类
            System.out.println(resources.nextElement()); // file:/D:/IdeaProject/CrazyJavaMaven/target/classes/
        }
        // 获取系统类加载器的父类加载器，得到扩展类加载器
        ClassLoader extensionLoader = systemClassLoader.getParent();
        System.out.println("扩展类加载器: " + extensionLoader);
        System.out.println("扩展类加载器的加载路径: " + System.getProperty("java.ext.dirs"));
        System.out.println("扩展类加载器的parent: " + extensionLoader.getParent());
    }
}

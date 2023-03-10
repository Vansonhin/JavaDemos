package session18reflect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader {
    private byte[] getBytes(String filename) throws IOException {
        File file = new File(filename);
        long length = file.length();
        byte[] raw = new byte[(int) length];
        try (FileInputStream fis = new FileInputStream(file)) {
            int read = fis.read(raw);
            if (read != length) {
                throw new IOException("无法读取全部文件: " + read + " != " + length);
            }
            return raw;
        }
    }

    private boolean compile(String javaFile) throws IOException {
        System.out.println("CompileClassLoader正在编译 " + javaFile + "...");
        // 调用javac命令
        Process p = Runtime.getRuntime().exec("javac " + javaFile);
        try {
            // 其他线程都等待这个线程完成
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取javac线程的退出值
        int ret = p.exitValue();
         // value 0 indicates normal termination
        return ret == 0;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = null;
        String fileStub = name.replace(".", "/");
        String javaFilename = fileStub + ".java";
        String classFilename = fileStub + ".class";
        File javaFile = new File(javaFilename);
        File classFile = new File(classFilename);
        // 当指定java源文件存在，且class文件不存在,或者java源文件的修改时间比class文件要晚时，重新编译
        if (javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())) {
            // 如果编译失败，或者该class文件不存在
            try {
                if (!compile(javaFilename) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException: " + javaFilename);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 如果class文件存在，系统负责将该文件转换成class对象
        if (classFile.exists()) {
            try {
                byte[] bytes = getBytes(classFilename);
                clazz = defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 表明加载失败
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("缺少目标类，请按如下格式运行Java源文件：");
            System.out.println("java CompileClassLoader ClassName");
        }
        String progClass = args[0];
        String[] progArgs = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CompileClassLoader loader = new CompileClassLoader();
        Class<?> clazz = loader.loadClass(progClass);
        Method main = clazz.getMethod("main", String[].class);
        Object[] argsArray = {progArgs};
        main.invoke(null, argsArray);
    }
}

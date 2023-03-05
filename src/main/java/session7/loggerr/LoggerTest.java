package session7.loggerr;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
    public static void main(String[] args) throws IOException {
        System.Logger logger = System.getLogger("loveJava");
        Logger.getLogger("loveJava").setLevel(Level.SEVERE);
        // 使用a.xml保存日志记录
        Logger.getLogger("loveJava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug");
        logger.log(System.Logger.Level.INFO, "info");
        logger.log(System.Logger.Level.ERROR, "error");
    }
}

package session15file.serialize;

import java.io.FileInputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class FilterTest {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/session15file/serialize/object.txt"))) {
            ois.setObjectInputFilter(info -> {
                ObjectInputFilter serialFilter = ObjectInputFilter.Config.getSerialFilter();
                if (serialFilter != null) {
                    ObjectInputFilter.Status status = serialFilter.checkInput(info);
                    if (status != ObjectInputFilter.Status.UNDECIDED) {
                        return status;
                    }
                }
                // 如果序列化数据中的对象不唯一(数据已被污染)
                if (info.references() != 1) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                if (info.serialClass() != null && info.serialClass() != Person.class) {
                    return ObjectInputFilter.Status.REJECTED;
                }
                return ObjectInputFilter.Status.UNDECIDED;
            });
            Person p = (Person) ois.readObject();
            System.out.println(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

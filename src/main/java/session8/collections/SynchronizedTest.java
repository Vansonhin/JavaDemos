package session8.collections;

import java.util.*;

public class SynchronizedTest {
    public static void main(String[] args) {
        Collection<Object> objects = Collections.synchronizedCollection(new ArrayList<>());
        List<Object> objects1 = Collections.synchronizedList(new ArrayList<>());
        Set<Object> objects2 = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
    }
}

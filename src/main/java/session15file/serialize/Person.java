package session15file.serialize;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class Person implements Serializable {
    private static final long serialVersionUID = 1978156477366612649L;

    private String name;
    private int age;

}

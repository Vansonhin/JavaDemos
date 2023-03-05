package session14.repeat;

import java.lang.annotation.Annotation;

@FkTag(name = "a", age = 1)
@FkTag(name = "b", age = 2)
public class Test {
    public static void main(String[] args) {
        Class<Test> clazz = Test.class;
        FkTag[] tags = clazz.getDeclaredAnnotationsByType(FkTag.class);
        for (FkTag tag : tags) {
            System.out.println(tag.name() + "-->" + tag.age());
        }

        FkTags container = clazz.getDeclaredAnnotation(FkTags.class);
        System.out.println(container);
    }
}

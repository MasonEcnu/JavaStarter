package annotation;

import java.lang.reflect.Method;

/**
 * Created by mwu on 2020/8/4
 */
public class TestAnnoDemo {

    @AnnoDemo(value = "这是TestAnnoDemo的main方法")
    public static void main(String[] args) {
        try {
            Method method = TestAnnoDemo.class.getDeclaredMethod("main", String[].class);
            if (method.isAnnotationPresent(AnnoDemo.class)) {
                AnnoDemo annoDemo = method.getAnnotation(AnnoDemo.class);
                System.out.println(annoDemo.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

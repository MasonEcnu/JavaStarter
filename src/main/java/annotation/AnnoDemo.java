package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mwu on 2020/8/4
 *
 * @description @interface 声明注解
 * @description @Target 元注解，标记注解的注解，标明注解可适用范围：方法
 * @description @Retention 声明注解的可获取范围，运行时
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoDemo {
    String value();
}

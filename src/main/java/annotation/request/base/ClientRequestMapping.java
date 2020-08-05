package annotation.request.base;

import annotation.request.message.MessageLite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mwu on 2020/8/5
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClientRequestMapping {
    Class<? extends MessageLite> value();
}

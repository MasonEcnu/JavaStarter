package annotation;

import annotation.request.RequestMappingFactory;
import annotation.request.base.ClientRequestMapping;
import annotation.request.message.HelloPlayerRequest;
import annotation.request.message.HelloWorldRequest;
import annotation.request.message.MessageLite;
import annotation.request.message.Player;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by mwu on 2020/8/5
 */
public class TestRequestMapping {

    public static void main(String[] args) {
        String packageName = "annotation";
        Map<Class<? extends MessageLite>, Method> methodMap = RequestMappingFactory.generateClientRequestMapping(packageName, ClientRequestMapping.class);
        HelloWorldRequest worldRequest = new HelloWorldRequest(123L, "HelloWorldRequest");
        HelloPlayerRequest playerRequest = new HelloPlayerRequest(123L);
        Player player = new Player(456L, "阿瓦达");
        try {
            Method method = methodMap.get(playerRequest.getClass());
            method.invoke(method.getDeclaringClass().newInstance(), player, playerRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

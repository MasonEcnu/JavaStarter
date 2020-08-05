package annotation.request.handlers;

import annotation.request.base.ClientRequestMapping;
import annotation.request.message.HelloWorldRequest;
import annotation.request.message.MessageLite;
import annotation.request.message.Player;

/**
 * Created by mwu on 2020/8/5
 */
public class WorldHandler {

    @ClientRequestMapping(value = HelloWorldRequest.class)
    public void testHelloWorldRequest(Player player, MessageLite msg) {
        HelloWorldRequest request = (HelloWorldRequest) msg;
        System.out.format("This is HelloWorldRequest, name:%s, msg:%s", player.name, request.worldId);
    }
}

package annotation.request.handlers;

import annotation.request.base.ClientRequestMapping;
import annotation.request.message.HelloPlayerRequest;
import annotation.request.message.MessageLite;
import annotation.request.message.Player;

/**
 * Created by mwu on 2020/8/5
 */
public class PlayerHandler {

    @ClientRequestMapping(value = HelloPlayerRequest.class)
    public void testHelloPlayerRequest(Player player, MessageLite msg) {
        HelloPlayerRequest request = (HelloPlayerRequest) msg;
        System.out.format("This is HelloPlayerRequest, name:%s, msg:%s", player.name, request.playerId);
    }
}

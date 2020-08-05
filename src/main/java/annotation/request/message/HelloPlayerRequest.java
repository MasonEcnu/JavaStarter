package annotation.request.message;

/**
 * Created by mwu on 2020/8/5
 */
public class HelloPlayerRequest extends MessageLite {

    public long playerId;

    public HelloPlayerRequest(long playerId) {
        this.playerId = playerId;
    }
}

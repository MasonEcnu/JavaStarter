package annotation.request.message;

/**
 * Created by mwu on 2020/8/5
 */
public class HelloWorldRequest extends MessageLite {

    public long worldId;

    public HelloWorldRequest(long worldId, String requestName) {
        this.requestName = requestName;
        this.worldId = worldId;
    }
}

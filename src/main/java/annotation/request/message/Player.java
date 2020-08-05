package annotation.request.message;

/**
 * Created by mwu on 2020/8/5
 */
public class Player {

    public long playerId;
    public String name;

    public Player(long playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }
}

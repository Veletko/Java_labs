import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final String nickname;
    private final Map<String, Integer> gameRatings;

    public Player(String nickname, List<String> games) {
        this.nickname = nickname;
        this.gameRatings = new HashMap<>();
        for (String game : games) {
            gameRatings.put(game, 0);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public Map<String, Integer> getGameRatings() {
        return new HashMap<>(gameRatings);
    }

    public void addRating(String game, int points) {
        gameRatings.merge(game, points, Integer::sum);
    }

    public int getTotalRating() {
        return gameRatings.values().stream().mapToInt(Integer::intValue).sum();
    }
}
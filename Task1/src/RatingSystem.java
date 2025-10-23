import java.util.*;
import java.util.stream.Collectors;

public class RatingSystem implements PlayerRegistry {
    private final Map<String, Player> players;

    public RatingSystem() {
        this.players = new HashMap<>();
    }

    @Override
    public boolean registerPlayer(String nickname, List<String> games) {
        if (players.containsKey(nickname)) {
            return false;
        }
        players.put(nickname, new Player(nickname, games));
        return true;
    }

    @Override
    public void addRating(String nickname, String game, int points) {
        Player player = players.get(nickname);
        if (player != null && player.getGameRatings().containsKey(game)) {
            player.addRating(game, points);
        }
    }

    @Override
    public List<String> getCommonGames() {
        if (players.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> commonGames = new HashSet<>(players.values().iterator().next().getGameRatings().keySet());
        for (Player player : players.values()) {
            commonGames.retainAll(player.getGameRatings().keySet());
        }
        return new ArrayList<>(commonGames);
    }

    @Override
    public int getPlayerRating(String nickname, String game) {
        Player player = players.get(nickname);
        return player != null ? player.getGameRatings().getOrDefault(game, 0) : 0;
    }

    @Override
    public List<Player> getTop10ByGame(String game) {
        return players.values().stream()
                .filter(p -> p.getGameRatings().containsKey(game))
                .sorted((p1, p2) -> p2.getGameRatings().get(game).compareTo(p1.getGameRatings().get(game)))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getTop10Overall() {
        return players.values().stream()
                .sorted(Comparator.comparingInt(Player::getTotalRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
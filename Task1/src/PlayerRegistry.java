import java.util.List;

public interface PlayerRegistry {
    boolean registerPlayer(String nickname, List<String> games);
    void addRating(String nickname, String game, int points);
    List<String> getCommonGames();
    int getPlayerRating(String nickname, String game);
    List<Player> getTop10ByGame(String game);
    List<Player> getTop10Overall();
}
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        RatingSystem system = new RatingSystem();

        // Регистрация игроков
        system.registerPlayer("Player1", Arrays.asList("Chess", "Poker", "CSGO"));
        system.registerPlayer("Player2", Arrays.asList("Chess", "Poker"));
        system.registerPlayer("Player3", Arrays.asList("Chess", "CSGO"));
        system.registerPlayer("Player4", Arrays.asList("Chess", "Poker", "CSGO"));

        // Проверка на занятость ника
        boolean isRegistered = system.registerPlayer("Player1", Arrays.asList("Chess"));
        System.out.println("Попытка зарегистрировать Player1 повторно: " + isRegistered);

        // Добавление рейтинга
        system.addRating("Player1", "Chess", 100);
        system.addRating("Player1", "Poker", 50);
        system.addRating("Player2", "Chess", 120);
        system.addRating("Player3", "CSGO", 200);
        system.addRating("Player4", "Chess", 80);

        // Вывод общих игр
        System.out.println("Общие игры: " + system.getCommonGames());

        // Вывод рейтинга игрока
        System.out.println("Рейтинг Player1 в Chess: " + system.getPlayerRating("Player1", "Chess"));

        // Вывод топ-10 по игре
        System.out.println("Топ-10 по Chess:");
        system.getTop10ByGame("Chess").forEach(p ->
                System.out.println(p.getNickname() + ": " + p.getGameRatings().get("Chess")));

        // Вывод общего топ-10
        System.out.println("Общий топ-10:");
        system.getTop10Overall().forEach(p ->
                System.out.println(p.getNickname() + ": " + p.getTotalRating()));
    }
}
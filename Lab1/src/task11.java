import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество секунд до Нового года: ");
        long totalSeconds = scanner.nextLong();

        // Вычисляем полные дни
        long days = totalSeconds / (24 * 60 * 60);
        long remainingSeconds = totalSeconds % (24 * 60 * 60);

        // Вычисляем полные часы
        long hours = remainingSeconds / (60 * 60);
        remainingSeconds %= (60 * 60);

        // Вычисляем полные минуты
        long minutes = remainingSeconds / 60;

        // Оставшиеся секунды
        long seconds = remainingSeconds % 60;

        // Формируем результат с правильными окончаниями
        String result = formatTime(days, hours, minutes, seconds);

        System.out.println(result);

        scanner.close();
    }

    // Метод для форматирования времени с правильными окончаниями
    public static String formatTime(long days, long hours, long minutes, long seconds) {
        StringBuilder result = new StringBuilder();

        if (days > 0) {
            result.append(days).append(getDayEnding(days));
            if (hours > 0 || minutes > 0 || seconds > 0) {
                result.append(", ");
            }
        }

        if (hours > 0) {
            result.append(hours).append(getHourEnding(hours));
            if (minutes > 0 || seconds > 0) {
                result.append(", ");
            }
        }

        if (minutes > 0) {
            result.append(minutes).append(getMinuteEnding(minutes));
            if (seconds > 0) {
                result.append(" и ");
            }
        }

        if (seconds > 0) {
            result.append(seconds).append(getSecondEnding(seconds));
        }

        // Если все нули (например, 0 секунд)
        if (result.length() == 0) {
            return "0 секунд";
        }

        return result.toString();
    }

    // Методы для правильных окончаний
    private static String getDayEnding(long days) {
        if (days % 10 == 1 && days % 100 != 11) return " день";
        if (days % 10 >= 2 && days % 10 <= 4 && (days % 100 < 10 || days % 100 >= 20)) return " дня";
        return " дней";
    }

    private static String getHourEnding(long hours) {
        if (hours % 10 == 1 && hours % 100 != 11) return " час";
        if (hours % 10 >= 2 && hours % 10 <= 4 && (hours % 100 < 10 || hours % 100 >= 20)) return " часа";
        return " часов";
    }

    private static String getMinuteEnding(long minutes) {
        if (minutes % 10 == 1 && minutes % 100 != 11) return " минута";
        if (minutes % 10 >= 2 && minutes % 10 <= 4 && (minutes % 100 < 10 || minutes % 100 >= 20)) return " минуты";
        return " минут";
    }

    private static String getSecondEnding(long seconds) {
        if (seconds % 10 == 1 && seconds % 100 != 11) return " секунда";
        if (seconds % 10 >= 2 && seconds % 10 <= 4 && (seconds % 100 < 10 || seconds % 100 >= 20)) return " секунды";
        return " секунд";
    }
}
package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static double getCountOfFreeEmails(List <String> emailsList) {
        return emailsList.stream()
                .filter(s -> (s.contains("@gmail.com") || s.contains("@yandex.ru") || s.contains("@hotmail.com")))
                .count();
    }
}
// END

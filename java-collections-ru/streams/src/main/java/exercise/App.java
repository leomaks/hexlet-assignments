package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> list) {
        long result = list.stream()
                .filter( x -> x.contains("@gmail.com") || x.contains("@yandex.ru") || x.contains("@hotmail.com"))
                .count();

        return (int)result;
    }


}

package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
class App{
    public static String getForwardedVariables(String input) {

        String result = Arrays.stream(input.split("\n"))
                .filter(str -> str.startsWith("environment="))
                .map(str -> str.replaceAll("environment=", ""))
                .map(str -> str.replaceAll("\"", ""))

                .flatMap(str -> Arrays.stream(str.split(",")))
                .filter(word -> word.startsWith("X_FORWARDED_"))
                .map(word -> word.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));

        return result;
    }
}

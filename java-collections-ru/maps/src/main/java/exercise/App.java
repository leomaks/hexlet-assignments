package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentense) {
        Map<String, Integer> map = new HashMap<>();
        List<String> words = Arrays.asList(sentense.split(" "));

        for (String word: words) {
            if (!word.equals("")) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        String result = "{\n";
        for (Map.Entry<String, Integer> word: map.entrySet()) {
            result = result  + "  " + word.getKey() + ": " + word.getValue() + "\n";
        }
        result += "}";

        if (map.isEmpty()) {
            result = "{}";
        }
        System.out.println(result);
        return result;
    }
}

//END

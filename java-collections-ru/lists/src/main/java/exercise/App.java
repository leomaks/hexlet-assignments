package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    // BEGIN
    public static boolean scrabble(String text, String word) {

        var tmpText = new ArrayList<Character>();
        for (var ch : text.toCharArray()) {
            tmpText.add(ch);
        }


        for (var letter : word.toLowerCase().toCharArray()) {
            var index = tmpText.indexOf(letter);
            if (index == 0) {
                return false;
            }
            tmpText.remove(index);
        }
        return true;
    }
}
//END

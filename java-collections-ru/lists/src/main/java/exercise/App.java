package exercise;

import java.util.List;
import java.util.ArrayList;
// BEGIN
class App {
    public static boolean scrabble(String alphabet, String word) {

        boolean hasAllChars = true;
        List<Character> listOfChars = new ArrayList<>();

        for (char ch: alphabet.toCharArray()) {
            listOfChars.add(ch);
        }

        for (int i = 0; i < word.length(); i++) {

            int index = listOfChars.indexOf(word.toLowerCase().charAt(i));

            if (index == -1) {
                hasAllChars = false;
                break;
            }
            listOfChars.remove(index);
        }

        return hasAllChars;
    }
}

//END

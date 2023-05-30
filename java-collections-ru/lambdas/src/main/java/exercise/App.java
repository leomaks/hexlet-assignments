package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] mas) {

        List<String[]> line = new ArrayList<>();
        Arrays.stream(mas)
                .forEach(x-> {
                    List<String> element = new ArrayList<>();

                    Arrays.stream(x).forEach(y-> {
                        element.add(y);
                        element.add(y);
                    });

                    line.add(element.toArray(new String[0]));
                    line.add(element.toArray(new String[0]));

                });

        return line.toArray(new String[0][0]);
    }

}
// END

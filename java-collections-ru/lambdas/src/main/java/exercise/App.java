package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String[] dublicate (String[] image) {

      return Arrays.stream(image)
              .flatMap(item -> Arrays.stream(new String[] {item, item}))
              .toArray(String[]::new);
    }
    public static String[][] enlargeArrayImage(String[][] image) {

        String[][] res =  Arrays.stream(image)
                .map(App::dublicate)
                .toArray(String[][]::new);


        return Arrays.stream(res)
                .flatMap(item -> Arrays.stream(new String[][] {item, item}))
                .toArray(String[][]::new);

    }
}

package exercise;

import java.util.List;
import java.util.stream.Collectors;

class App {
    public static List<String> buildApartmentsList(List<Home> aparts, int n) {
        return aparts.stream()
                .sorted(Home::compareTo)
                .map(Home::toString)
                .limit(n)
                .toList();
    }
}

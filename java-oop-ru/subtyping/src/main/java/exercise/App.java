package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
class App {


    public static void swapKeyValue(KeyValueStorage baza) {
        Map<String, String> mapa = baza.toMap();

        mapa.entrySet().stream()
                .forEach(x -> {
                    var key = x.getKey();
                    var value = x.getValue();
                    baza.set(value, key);
                    baza.unset(key);
                });

    }
}


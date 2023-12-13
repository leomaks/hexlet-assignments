package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String name;
    private Map<String, String> map;

    public String getName() {
        return name;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public Tag(String name, Map<String, String> map) {
        this.name = name;
        this.map = map;
    }

    public String toString() {
        String temp = map.entrySet().stream()
                .map(x -> (x.getKey() + "=\"" + x.getValue() + "\""))
                .collect(Collectors.joining(" "));

        String mapStr = map.isEmpty() ? "" : " " + temp;

        return "<" + getName() + mapStr + ">";

    }

}


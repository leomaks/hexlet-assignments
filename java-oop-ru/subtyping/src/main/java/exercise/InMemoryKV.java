package exercise;

import java.util.Map;
import java.util.HashMap;

public class InMemoryKV implements KeyValueStorage {
    HashMap<String, String> map;

    public InMemoryKV(Map<String, String> map) { this.map = new HashMap<>(map); }

    public void set(String key, String value) { map.put(key, value); }


    public void unset(String key) {
        this.map.remove(key);
    }


    public String get(String key, String defaultValue) {
        return this.map.getOrDefault(key, defaultValue);
    }


    public HashMap<String, String> toMap() {

      return new HashMap<>(map);
    }
}


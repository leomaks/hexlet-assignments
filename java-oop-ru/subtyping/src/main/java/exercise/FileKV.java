package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
  //  private HashMap<String, String> map;
    private String path;

    FileKV(String path, Map<String, String> map) {
        this.path = path;
        String json = Utils.serialize(map);
        Utils.writeFile(path, json);
    }

    public void set(String key, String value) {


        String json = Utils.readFile(this.path);
        var map = new HashMap<>(Utils.unserialize(json));
        map.put(key, value);

        new FileKV(path, map);
    }

    public void unset(String key) {


        String json = Utils.readFile(this.path);
        var map = new HashMap<>(Utils.unserialize(json));
        map.remove(key);

        new FileKV(path, map);
    }

    public String get(String key, String defaultValue) {

        String json = Utils.readFile(this.path);
        var map = new HashMap<>(Utils.unserialize(json));

        return map.getOrDefault(key, defaultValue);
    }

    public Map<String, String> toMap() {
        String json = Utils.readFile(this.path);
        var map = new HashMap<>(Utils.unserialize(json));
        return map;
    }
}


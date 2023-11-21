package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2 ) {

        var result = new LinkedHashMap<String, String>();
        var res = new TreeSet<String>();
        res.addAll(data1.keySet());
        res.addAll(data2.keySet());

        for (var key: res) {
            String s = data1.keySet().contains(key) ?
                            data2.keySet().contains(key) ?
                                    (data1.get(key).equals(data2.get(key)) ? result.put(key, "unchanged") : result.put(key, "changed"))
                            : result.put(key, "deleted")
                    : result.put(key, "added");
        }

        return result;
    }

}
//END

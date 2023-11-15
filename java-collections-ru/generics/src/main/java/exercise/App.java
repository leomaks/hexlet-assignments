package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static <T>List<Map<T, T>> findWhere(List<Map<T, T>> books, Map <T, T> where){

        var result = new ArrayList<Map<T, T>>();

        for (Map<T, T> book: books ) {

            boolean isFit = true;

            for (var condition: where.entrySet()){
                var key = condition.getKey();

                if (book.get(key) != condition.getValue()) {
                    isFit = false;
                }
            }

            if (isFit) {
                result.add(book);
            }

        }

        return result;
    }
}

//END


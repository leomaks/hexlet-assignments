package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
class App {
    public static <T>List<Map<T,T>> findWhere(List<Map<T,T>> books, Map<T,T> filter) {

        List<Map<T, T>> resultBooks = new ArrayList<>();
        for (Map<T,T> book: books) {
            boolean isMatch = true;
            for (Map.Entry<T,T> criterion: filter.entrySet()){
                if (!book.get(criterion.getKey()).equals(criterion.getValue())) {
                    isMatch = false;
                }
            }
            if (isMatch) {
                Map<T, T> book1 =  new HashMap<>(book);
                resultBooks.add(book1);
            }
        }

        return resultBooks;
    }
}
//END

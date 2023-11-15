package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String text){

        var words = text.split(" ");
        var dictionary = new HashMap<String, Integer>();

        if (text.length() == 0) {
            return dictionary;
        }

        for (var word: words) {
            var count = dictionary.getOrDefault(word, 0);
            dictionary.put(word, count+1);
        }
       return dictionary;
    }
   public static String toString(Map<String, Integer> map){
        if (map.isEmpty())
            return "{}";
        var result = "{";
        for (var word: map.entrySet()) {
               result = result + "\n" + "  " + word.getKey() + ": " + word.getValue();
        }

        return result + "\n}";
    }

}
//END

/*
С* В классе `App` создайте публичный статический метод `toString()`, который принимает в качестве аргумента словарь `Map`
* с количеством слов в предложении. Метод должен возвращать строковое представление словаря.
* Обратите внимание на форматирование вывода. Результат должен быть заключен в фигурные скобки, каждое слово выводится с новой строки с отступом в 2 пробела.

```java
String sentence = "the java is the best programming language java";
Map wordsCount = App.getWordCount(sentence);
String result = App.toString(wordsCount);
System.out.println(result); // =>
// {
//   the: 2
//   java: 2
//   is: 1
//   best: 1
//   language: 1
//   programming: 1
// }

*/
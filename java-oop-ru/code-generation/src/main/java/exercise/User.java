package exercise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

// BEGIN
@Data
@AllArgsConstructor
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}



/* В файле создан класс `User`, который описывает владельца автомобиля. В классе уже определены все свойства, но нет конструктора и геттеров.
        * Допишите нужную аннотацию lombock, чтобы автоматически сгенерировать конструктор и геттеры для всех свойств и сделать класс неизменяемым.

        ```java
User owner = new User(1, "Ivan", "P", 25);
// Вызываем автоматически сгенерированный геттер
owner.getFirstName(); // "Ivan"

 */
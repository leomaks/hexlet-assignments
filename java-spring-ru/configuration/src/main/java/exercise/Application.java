package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import  org.springframework.beans.factory.annotation.Autowired;

import exercise.model.User;
import exercise.component.UserProperties;

@SpringBootApplication
@RestController
public class Application {

    // Все пользователи
    private List<User> users = Data.getUsers();
    @Autowired // Аннотация нужна для автоподстановки объекта
    private UserProperties adminInfo;


    // BEGIN
/*    В конфигурационном файле приложения в свойстве `users.admins` записаны email администраторов нашего ресурса.
Добавьте в приложение обработчик, который при GET-запросе на адрес
/admins* вернет список имен администраторов. Список должен быть отсортирован по имени пользователя в прямом порядке.
 */

    // END

    @GetMapping("/users")
    public List<User> index() {
        return users;
    }

    @GetMapping("/users/{id}")
    public Optional<User> show(@PathVariable Long id) {
        var user = users.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
        return user;
    }




    @GetMapping("/admins")
    public ArrayList<String> showAdmins() {
       List<String> adminsEmails = adminInfo.getAdmins();
       var names = new ArrayList<String>();
       
       for (var email:adminsEmails) {
           names.add(users.stream().filter(user -> user.getEmail().contains(email)).findFirst().get().getName());
       }

       return names;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

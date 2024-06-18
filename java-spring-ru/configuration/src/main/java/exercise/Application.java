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
    public List<String> showAdmins() {
       List<String> adminsEmails = adminInfo.getAdmins();

       return users.stream()
               .filter(u->adminsEmails.contains(u.getEmail()))
               .map(u->u.getName())
               .sorted()
               .toList();

    }
    // END
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

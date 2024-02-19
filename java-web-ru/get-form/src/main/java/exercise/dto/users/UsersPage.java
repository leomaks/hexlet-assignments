package exercise.dto.users;

import exercise.model.User;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString

public class UsersPage {
    public UsersPage(ArrayList<User> users, String term) {
        this.users = users;
        this.term = term;
    }

    public ArrayList<User> users;
    public String term;

}


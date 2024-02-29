package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import exercise.model.User;


@Getter
@AllArgsConstructor

public class UserPage {
    private User user;
}

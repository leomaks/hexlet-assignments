package exercise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginPage {
    public LoginPage(String name) {
        this.name = name;
    }

    private String name;
    private String error;
}

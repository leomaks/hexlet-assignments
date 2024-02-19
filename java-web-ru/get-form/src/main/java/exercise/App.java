package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

public final class App {
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            UsersPage page;
            List<User> users;
            
            if (term!=null) {
                users = USERS.stream()
                        .filter(user ->StringUtils.startsWithIgnoreCase(user.getFirstName(),(term)))
                        .toList();
            } else {
                users = USERS;
            }

            page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));

        });


        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}

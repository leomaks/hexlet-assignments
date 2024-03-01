package exercise.controller;

import java.util.Collections;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.repository.UsersRepository;

import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    public static void build(Context ctx) {
        var page = new LoginPage("");
        ctx.render("sessions/build.jte", Collections.singletonMap("page", page));

    }

    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {

        var name = ctx.formParamAsClass("name", String.class).get().trim();
        var user = UsersRepository.findByName(name);
        var sessionPassword = Security.encrypt(ctx.formParam("password")).hashCode();

        if ((user != null) && (user.getPassword().hashCode() == sessionPassword)) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect("/");
        } else {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("sessions/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");
    }


}



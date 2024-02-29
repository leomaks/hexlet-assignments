package exercise.controller;

import exercise.dto.UserPage;
import io.javalin.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

/*
    var visited = Boolean.valueOf(ctx.cookie("visited"));
    var page = new MainPage(visited);
            ctx.render("index.jte", Collections.singletonMap("page", page));
            ctx.cookie("visited", String.valueOf(true));

 */

    public static void create (Context ctx) {
        var firstName = ctx.formParam("firstName").trim();
        var lastName = ctx.formParam("lastName").trim();
        var email = ctx.formParam("email").trim().toLowerCase();
        var password = ctx.formParamAsClass("password", String.class).get();
        var token = Security.generateToken();
        ctx.cookie("token", token);
        var user = new User(firstName, lastName, email, password,  token);


        UserRepository.save(user);
        var id = user.getId();
        var path = NamedRoutes.userPath(id);
        ctx.redirect(path);

    }

    public static void show (Context ctx) {

        var id = ctx.pathParam("id");

        var user = UserRepository.find(Long.valueOf(id)).get();
        var page = new UserPage(user);
        if ( user.getToken().equals(ctx.cookie("token"))) {
            ctx.render("users/show.jte", Collections.singletonMap("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }

    }

}

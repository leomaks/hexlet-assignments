package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

public class PostsController {

    public static void show (Context ctx) {
        try {
            var id = ctx.pathParam("id");
            var post = PostRepository.find(Long.valueOf(id));
            var page = new PostPage(post.get());
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
       } catch (Exception e) {
            ctx.status(404);
            ctx.result("Page not found");
        }
    }

    public static void index (Context ctx) {

        int currentSitePage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        if ((currentSitePage) < 1) {
            currentSitePage = 1;
        }
        int per = 5;
        List<Post> postsResult = new ArrayList<>();

        var posts = PostRepository.getEntities();
        var end = posts.size()/per + 1;

        if ((currentSitePage) > end) {
            currentSitePage = end;
        }

        int start = (currentSitePage - 1) * per;

        for (var i = start; i < Integer.min(posts.size(),start + per) ; i++) {
            postsResult.add(posts.get(i));
        }

        var page = new PostsPage(currentSitePage, postsResult);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }


    /*
      app.get("/users", ctx -> {
        int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int per =  ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
        List<Map<String, String>> usersResult = new ArrayList<>();
        int start = (page - 1) * per;

        for (var i = start; i < Integer.min(users.size(),start + per) ; i++) {
            usersResult.add(users.get(i));
        }

        ctx.json(usersResult);
    }
        );

     */
    /*
    ### src/main/java/exercise/controller/PostController.java

Реализуйте контроллер с двумя обработчиками.
Второй обработчик должен:

* Показывать страницу со списком всех постов, причем каждый пост из списка должен вести на страницу конкретного поста
* Выводить список постов с пейджингом по 5 постов на странице. На первой странице первые пять постов, на второй пять и так далее
* Позволять переключаться между страницами с помощью двух ссылок — назад и вперед

То, какая сейчас страница открыта, определяется параметром строки запроса `page`. По умолчанию загружается первая страница.
     */

    // BEGIN
    
    // END
}

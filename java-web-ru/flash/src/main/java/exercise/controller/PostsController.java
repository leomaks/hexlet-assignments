package exercise.controller;

import java.util.Collections;
import java.util.List;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        var page = new PostsPage(posts);

        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {

        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название должно быть не короче 2х символов")
                    .get();
            var body = ctx.formParamAsClass("body", String.class).get();
            var post = new Post(name,body);
            PostRepository.save(post);

            ctx.sessionAttribute("flash", "Пост был успешно создан!");
            ctx.sessionAttribute("postCreated", true);
            ctx.redirect(NamedRoutes.postsPath());

        } catch (ValidationException e) {
            var name = ctx.formParamAsClass("name", String.class).get();
            var body = ctx.formParamAsClass("body", String.class).get();
            var page = new BuildPostPage(name, body, e.getErrors());

            ctx.sessionAttribute("flash", "Error, the item was not created");
            page.setFlash(ctx.consumeSessionAttribute("flash"));
            ctx.render("posts/build.jte", Collections.singletonMap("page", page));
        }

    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}

package exercise.dto.posts;

import exercise.model.Post;

import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

//@AllArgsConstructor
@Getter
public class PostPage {
    private Post post;

    public PostPage(Post post) {

        this.post = post;
    }
}

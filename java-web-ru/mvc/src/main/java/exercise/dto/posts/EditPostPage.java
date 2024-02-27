package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.model.Post;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN
/* Реализуйте дата-класс для передачи данных поста в шаблон с формой редактирования.*/
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EditPostPage {
    private Long id;
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;

    public EditPostPage(String id, String name, String body, Map<String, List<ValidationError<Object>>> errors) {
        this.id = Long.getLong(id);
        this.name = name;
        this.body = body;
        this.errors = errors;
    }

    public EditPostPage(Long id, String name, String body ) {
        this.name = name;
        this.body = body;
        this.id = id;
    }



    public EditPostPage (Post post) {
        this.name = post.getName();
        this.body = post.getBody();
        this.id = post.getId();
    }


}

package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN

@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> show (@PathVariable String id) {
        var result = posts.stream()
                .filter(p-> String.valueOf(p.getUserId()).equals(id))
                .toList();

        return ResponseEntity.status(200)
                .body(result);
    }

    @PostMapping("/users/{id}/posts") // Создание страницы
    public ResponseEntity<Post> create(@PathVariable int id, @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }


}

// END

package exercise.dto.articles;

import io.javalin.validation.ValidationError;
import java.util.Map;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BuildArticlePage {
    public String title;
    public String content;

    public BuildArticlePage(Map<String, List<ValidationError<Object>>> errors) {
        this.errors = errors;
    }

    public Map<String, List<ValidationError<Object>>> errors;



   // public BuildArticlePage(Map<String, List<ValidationError<Object>>> errors) {
  //      this.errors = errors;
  //  }

/*

    public BuildArticlePage(String title, Map<String, List<ValidationError<Object>>> errors) {
        this.title = title;
        this.errors = errors;
    }

    */


}

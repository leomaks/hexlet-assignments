package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private String body;
    private List<Tag> listTegs;
    public PairedTag(String name, Map<String, String> map, String body, List<Tag> listTegs) {
        super(name, map);
        this.body = body;
        this.listTegs = listTegs;
    }

    @Override
    public String toString() {

        String temp = listTegs.stream()
                .map(x -> x.toString())
                .collect(Collectors.joining());

        return super.toString() + body + temp + "</" + getName() + ">";

    }
}
// END

/*
/*
Tag img = new SingleTag("img", Map.of("class", "v-10", "id", "wop"));
img.toString(); // "<img class="v-10" id="wop">

* В классе реализуйте публичный метод `toString()`, который возвращает текстовое представление тега в виде строки.

        ```java
Tag p = new PairedTag(
        "p",
        Map.of("id", "abc"),
        "Text paragraph",
        new ArrayList<Tag>()
);

p.toString(); // "<p id="abc">Text paragraph</p>"

Tag div = new PairedTag(
        "div",
        Map.of("class", "y-5"),
        "",
        List.of(
                new SingleTag("br", Map.of("id", "s")),
                new SingleTag("hr", Map.of("class", "a-5"))
        )
)

div.toString(); // "<div class="y-5"><br id="s"><hr class="a-5"></div>"

 */

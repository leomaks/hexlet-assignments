package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


class AppTest {

    @Test
    void testBuildApartmentsList1() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Flat(41, 3, 10),
            new Cottage(125.5, 2),
            new Flat(80, 10, 2),
            new Cottage(150, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "Квартира площадью 44.0 метров на 10 этаже",
            "Квартира площадью 90.0 метров на 2 этаже",
            "2 этажный коттедж площадью 125.5 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void testBuildApartmentsList2() {
        List<Home> apartments = new ArrayList<>(List.of(
            new Cottage(100, 1),
            new Flat(190, 10, 2),
            new Flat(180, 30, 5),
            new Cottage(250, 3)
        ));

        List<String> expected = new ArrayList<>(List.of(
            "1 этажный коттедж площадью 100.0 метров",
            "Квартира площадью 200.0 метров на 2 этаже",
            "Квартира площадью 210.0 метров на 5 этаже",
            "3 этажный коттедж площадью 250.0 метров"
        ));

        List<String> result = App.buildApartmentsList(apartments, 4);
        assertThat(result).isEqualTo(expected);

    }

    @Test
    void testBuildApartmentsList3() {
        List<Home> apartments = new ArrayList<>();
        List<String> expected = new ArrayList<>();
        List<String> result = App.buildApartmentsList(apartments, 10);
        assertThat(result).isEqualTo(expected);
    }

    // BEGIN
    @Test
    void CharSequenceToString() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.toString();
        var expected = "fedcba";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void CharSequenceChatAt() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.charAt(1);
        var expected = 'e';
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void CharSequenceLength() {
        CharSequence text = new ReversedSequence("abcdef");
        var result = text.length();
        var expected = 6;
        assertThat(result).isEqualTo(expected);
    }
    // END
}
/* CharSequence text = new ReversedSequence("abcdef");
text.toString(); // "fedcba"
text.charAt(1); // 'e'
text.length(); // 6
text.subSequence(1, 4).toString(); // "edc"
```

 */
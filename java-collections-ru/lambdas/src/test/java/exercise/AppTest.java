package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.List;

class AppTest {
    @Test
    void testSorterWithEmptyList() {

        String[][] image = {};
        String[][] result = App.enlargeArrayImage(image);

        int actual = result.length;
        int expected = 0;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testApp() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };

        String[][] result = App.enlargeArrayImage(image);

        int actual = result.length;
        int expected = image.length * 2;
        assertThat(actual).isEqualTo(expected);

        int actual2 = result[0].length;
        int expected2 = image[0].length * 2;

        assertThat(actual2).isEqualTo(expected2);
    }

}

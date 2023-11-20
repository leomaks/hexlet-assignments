package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
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

        String[][] enlargedImage = {
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", " ", " ", " ", " ", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
                        {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] actual1 = App.enlargeArrayImage(image);
        assertThat(actual1).isDeepEqualTo(enlargedImage);
    }
}


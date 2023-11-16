package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {

    List <Integer> numbers;

    @BeforeEach
    void initIntegerList(){
        this.numbers = List.of(1,2,3,4,5,6,7,8,9,0);
    }
    @Test
    void testTake() {
        // BEGIN
        var actual = App.take(numbers, 5);
        var list = List.of(1,2,3,4,5);
        assertThat(actual).isEqualTo(list);


        var actual2 = App.take(numbers, 10);
        var list2 = List.of(1,2,3,4,5,6,7,8,9,0);
        assertThat(actual2).isEqualTo(list2);

        var actual3 = App.take(numbers, 1);
        var list3 = List.of(1);
        assertThat(actual3).isEqualTo(list3);


        var actual4 = App.take(numbers, 0);
        var list4 = new ArrayList<Integer>();
        assertThat(actual4).isEqualTo(list4);

        // END
    }
}

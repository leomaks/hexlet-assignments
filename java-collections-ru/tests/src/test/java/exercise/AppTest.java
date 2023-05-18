package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    List <Integer> list;

    @BeforeEach
     void initIntegerList() {
        this.list = new ArrayList<>();
        this.list.add(1);
        this.list.add(2);
        this.list.add(3);
        this.list.add(4);
        this.list.add(5);
        this.list.add(6);

    }
    @Test
    void testTake() {
        // BEGIN
        int expected = 4;
        int actual = App.take(list,4).size();
        Assertions.assertEquals(expected, actual);
        // END
    }
}

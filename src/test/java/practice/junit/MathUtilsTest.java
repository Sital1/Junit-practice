package practice.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    // lets junit know this is a test
    @Test
    void test()
    {
        MathUtils mathUtils = new MathUtils();

        int expected = 2;
        int actual = mathUtils.add(1, 1);

        // using assertion
        assertEquals(expected,actual,"The add method should add two numbers");

    }

}
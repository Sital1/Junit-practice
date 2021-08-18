package practice.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    // lets junit know this is a test
    @Test
    void testAdd()
    {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        // using assertion
        assertEquals(expected,actual,"The add method should add two numbers");
    }

    @Test
    void testCircleArea()
    {
        MathUtils mathUtils = new MathUtils();
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(10),"Should return right circle area");
    }

    @Test
    void testDivide()
    {
        MathUtils mathUtils = new MathUtils();
        assertThrows(ArithmeticException.class,()-> mathUtils.divide(1,0),"divide by zero should throw");
    }

}
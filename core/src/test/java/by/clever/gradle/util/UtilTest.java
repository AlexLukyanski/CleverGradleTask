package by.clever.gradle.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void should_returnTrue_When_AllNumberArePositive() {

        //given
        Util util = new Util();
        String[] numbers = {"1","12.2","33.6"};

        //then
        assertTrue(util.isAllPositiveNumbers(numbers));
    }

}
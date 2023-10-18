package by.clever.gradle.basic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilTest {

    @Test
    void should_ThrowNumberFormatException_When_ArgumentNonParsableToDouble() {

        //given
        String number = "NotANumber";
        StringUtil stringUtil = new StringUtil();

        //when
        Executable executable = () -> stringUtil.isPositiveNumber(number);

        //then
        assertThrows(NumberFormatException.class, executable);
    }
}
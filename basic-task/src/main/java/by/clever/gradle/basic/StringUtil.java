package by.clever.gradle.basic;

public class StringUtil {

    public boolean isPositiveNumber(String str) {

        double number = Double.parseDouble(str);

        if (number > 0) {
            return true;
        }
        return false;
    }
}

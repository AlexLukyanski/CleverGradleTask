package by.clever.gradle.util;

import by.clever.gradle.basic.StringUtil;


public class Util {

    public boolean isAllPositiveNumbers(String... args) {

        StringUtil stringUtil = new StringUtil();
        boolean isAllPositive = true;

        for (String number : args) {
            if (!stringUtil.isPositiveNumber(number)) {
                isAllPositive = false;
                break;
            }
        }
        return isAllPositive;
    }
}
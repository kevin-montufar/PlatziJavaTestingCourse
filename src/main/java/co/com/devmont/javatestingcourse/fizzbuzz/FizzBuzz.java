package co.com.devmont.javatestingcourse.fizzbuzz;

import co.com.devmont.javatestingcourse.fizzbuzz.enums.FizzBuzzValues;

public class FizzBuzz {

    public String calculate(int value) {
        String result = "";

        if (value % 3 == 0) {
            result += String.valueOf(FizzBuzzValues.FIZZ);
        }
        if (value % 5 == 0) {
            result += String.valueOf(FizzBuzzValues.BUZZ);
        }
        return !result.equals("") ? result :  value + "";
    }
}

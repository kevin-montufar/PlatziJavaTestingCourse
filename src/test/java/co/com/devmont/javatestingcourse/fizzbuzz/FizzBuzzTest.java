package co.com.devmont.javatestingcourse.fizzbuzz;

import co.com.devmont.javatestingcourse.fizzbuzz.enums.FizzBuzzValues;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz;

    @Before
    public void before() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void fizzWhenValueIsDivisibleBy3() {
        assertEquals(String.valueOf(FizzBuzzValues.FIZZ), fizzBuzz.calculate(18));
    }

    @Test
    public void buzzWhenValueIsDivisibleBy5() {
        assertEquals(String.valueOf(FizzBuzzValues.BUZZ), fizzBuzz.calculate(20));
    }

    @Test
    public void fizzBuzzWhenValueIsDivisibleBy3and5() {
        assertEquals(String.valueOf(FizzBuzzValues.FIZZ) + FizzBuzzValues.BUZZ, fizzBuzz.calculate(15));
    }

    @Test
    public void returnValueWhenValueIsNotDivisibleByThreeNeitherFive() {
        assertEquals("1", fizzBuzz.calculate(1));
    }
}
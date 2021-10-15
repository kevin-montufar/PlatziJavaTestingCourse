package co.com.devmont.javatestingcourse.util;

import org.junit.Assert;
import org.junit.Test;

import static co.com.devmont.javatestingcourse.util.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void passwordIsWeakWhenHasLessThanEightCharacters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void passwordIsWeakWhenOnlyHasLetters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abasdfasdfasdf"));
    }

    @Test
    public void passwordIsMediumWhenHasLettersAndNumbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("1234aaaa"));
    }

    @Test
    public void passwordIsMediumWhenHasLettersNumbersAndSymbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("?!!!1234aaaa"));
    }
}
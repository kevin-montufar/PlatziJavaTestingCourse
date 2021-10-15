package co.com.devmont.javatestingcourse.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DateUtilLeapYearShould {
    @Test
    public void returnTrueWhenYearIsDivisibleBy400() {
        assertThat( DateUtil.isLeapYear(1600), is(true));
        assertThat( DateUtil.isLeapYear(2000), is(true));
        assertThat( DateUtil.isLeapYear(2400), is(true));
    }
    @Test
    public void returnTrueWhenYearIsDivisibleBy100ButNotBy400() {
        assertThat( DateUtil.isLeapYear(1700), is(false));
        assertThat( DateUtil.isLeapYear(1800), is(false));
        assertThat( DateUtil.isLeapYear(1900), is(false));
    }
    @Test
    public void returnTrueWhenYearIsDivisibleBy4ButNotBy100() {
        assertThat( DateUtil.isLeapYear(1996), is(true));
        assertThat( DateUtil.isLeapYear(2004), is(true));
        assertThat( DateUtil.isLeapYear(2008), is(true));
    }

    @Test
    public void returnTrueWhenYearIsNotDivisibleBy4() {
        assertThat( DateUtil.isLeapYear(2017), is(false));
        assertThat( DateUtil.isLeapYear(2018), is(false));
        assertThat( DateUtil.isLeapYear(2019), is(false));
    }
}
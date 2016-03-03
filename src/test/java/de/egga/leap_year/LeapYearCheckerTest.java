package de.egga.leap_year;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LeapYearCheckerTest {

    LeapYearChecker leapYearChecker = new LeapYearChecker();

    @Test
    public void isNotLeapYear() {
        boolean isLeapYear = leapYearChecker.isLeapYear(1);
        assertThat(isLeapYear).isFalse();
    }

    @Test
    public void isLeapYearIfDivisibleBy400() {
        boolean isLeapYear = leapYearChecker.isLeapYear(400);
        assertThat(isLeapYear).isTrue();
    }

    @Test
    public void isNotLeapYearIfDivisibleBy100ButNotBy400() {
        boolean isLeapYear = leapYearChecker.isLeapYear(400 - 100);
        assertThat(isLeapYear).isFalse();
    }

    @Test
    public void isLeapYearIfDivisibleBy400_2() {
        boolean isLeapYear = leapYearChecker.isLeapYear(400 * 2);
        assertThat(isLeapYear).isTrue();
    }

    @Test
    public void isLeapYearIfDivisibleBy4() {
        boolean isLeapYear = leapYearChecker.isLeapYear(4);
        assertThat(isLeapYear).isTrue();
    }
}

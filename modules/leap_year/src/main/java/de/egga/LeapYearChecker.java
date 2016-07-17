package de.egga;

public class LeapYearChecker {

    public boolean isLeapYear(int year) {
        if (isDivisibleBy400(year)) {
            return true;
        }
        if (isDivisibleBy100(year)) {
            return false;
        }
        if (isDivisibleBy4(year)) {
            return true;
        }
        return false;
    }

    private boolean isDivisibleBy400(int year) {
        return isDivisibleBy(year, 400);
    }

    private boolean isDivisibleBy100(int year) {
        return isDivisibleBy(year, 100);
    }

    private boolean isDivisibleBy4(int year) {
        return isDivisibleBy(year, 4);
    }

    private boolean isDivisibleBy(int year, int i) {
        return year % i == 0;
    }
}

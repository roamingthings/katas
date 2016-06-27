package de.egga.bowling2;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculatorTest {

    ScoreCalculator calculator = new ScoreCalculator();

    @Test
    public void score_should_be_zero_before_first_roll() {
        int score = calculator.score();
        assertThat(score).isEqualTo(0);
    }

    @Test
    public void score_should_reflect_roll() {
        calculator.roll(8);
        int score = calculator.score();
        assertThat(score).isEqualTo(8);
    }

    @Test
    public void score_should_not_increase_if_rolled_zero() {
        calculator.roll(8);
        int score = calculator.score();
        calculator.roll(0);
        int score2 = calculator.score();
        assertThat(score).isEqualTo(score2);
    }

    @Test
    public void score_should_be_sum_of_rolls() {
        calculator.roll(2);
        calculator.roll(3);
        int score = calculator.score();
        assertThat(score).isEqualTo(5);
    }

    @Test
    public void score_should_be_sum_of_rolls2() {
        calculator.roll(3);
        calculator.roll(7);
        calculator.roll(5);
        int score = calculator.score();
        assertThat(score).isEqualTo(3 + 7 + 5 * 2);
    }

}

package de.egga.bowling;

import org.junit.Test;

import java.util.List;

import static com.google.common.primitives.Ints.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoreCalculatorTest {

    @Test
    public void it_should_add_simple_scores() {
        List<Integer> rolls = asList(1, 1);
        int score = ScoreCalculator.calc(rolls);
        assertThat(score).isEqualTo(2);
    }

    @Test
    public void it_should_add_double_score_for_spare() {
        List<Integer> rolls = asList(5, 5, 1);
        int score = ScoreCalculator.calc(rolls);
        assertThat(score).isEqualTo(12);
    }

    @Test
    public void it_should_add_two_double_scores_for_strike() {
        List<Integer> rolls = asList(10, 1, 2);
        int score = ScoreCalculator.calc(rolls);
        assertThat(score).isEqualTo(16);
    }




}
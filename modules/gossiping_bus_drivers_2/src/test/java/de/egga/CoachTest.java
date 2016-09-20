package de.egga;

import org.junit.Test;

import static de.egga.DriverTest.anyDriver;
import static org.assertj.core.api.StrictAssertions.assertThat;

public class CoachTest {

    public static final int FIRST_STOP = 1;
    public static final int SECOND_STOP = 2;

    @Test
    public void coach_should_be_at_first_stop() {
        Coach coach = new Coach(anyDriver(), anyRoute());

        assertThat(coach.isAtStop(FIRST_STOP)).isTrue();
    }

    @Test
    public void coach_should_proceed_to_second_stop() {
        Coach coach = new Coach(anyDriver(), anyRoute());
        coach.proceed();
        assertThat(coach.isAtStop(FIRST_STOP)).isFalse();
        assertThat(coach.isAtStop(SECOND_STOP)).isTrue();
    }


    private Integer[] anyRoute() {
        return new Integer[]{FIRST_STOP, SECOND_STOP, 3};
    }
}
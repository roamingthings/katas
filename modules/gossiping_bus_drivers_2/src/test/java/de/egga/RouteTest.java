package de.egga;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class RouteTest {

    public static final int FIRST_STOP = 1;
    public static final int SECOND_STOP = 2;

    @Test
    public void coach_should_be_at_first_stop() {
        Route route = new Route(anyRoute());

        assertThat(route.isAtStop(FIRST_STOP)).isTrue();
    }

    @Test
    public void coach_should_proceed_to_second_stop() {
        Route route = new Route(anyRoute());
        route.proceed();
        assertThat(route.isAtStop(FIRST_STOP)).isFalse();
        assertThat(route.isAtStop(SECOND_STOP)).isTrue();
    }


    private Integer[] anyRoute() {
        return new Integer[]{FIRST_STOP, SECOND_STOP, 3};
    }
}
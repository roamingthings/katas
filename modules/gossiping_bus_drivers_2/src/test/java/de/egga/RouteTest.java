package de.egga;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class RouteTest {

    public static final int FIRST_STOP = 1;
    public static final int SECOND_STOP = 2;
    public static final int ANY_STOP = 3;

    @Test
    public void it_should_be_at_first_stop() {
        Route route = anyRoute();

        assertThat(route.isAtStop(FIRST_STOP)).isTrue();
    }

    @Test
    public void it_should_proceed_to_second_stop() {
        Route route = anyRoute();
        route.proceed();
        assertThat(route.isAtStop(FIRST_STOP)).isFalse();
        assertThat(route.isAtStop(SECOND_STOP)).isTrue();
    }

    @Test
    public void it_should_be_at_same_stop_from_the_beginning() {
        Route thisRoute = new Route(FIRST_STOP);
        Route otherRoute = new Route(FIRST_STOP);

        assertThat(thisRoute.isAtSameStop(otherRoute)).isTrue();
    }

    @Test
    public void it_should_be_at_same_stop_after_one_minbute() {
        Route thisRoute = new Route(FIRST_STOP, SECOND_STOP);
        Route otherRoute = new Route(ANY_STOP, SECOND_STOP);

        assertThat(thisRoute.isAtSameStop(otherRoute)).isFalse();

        thisRoute.proceed();
        otherRoute.proceed();

        assertThat(thisRoute.isAtSameStop(otherRoute)).isTrue();
    }

    public static Route anyRoute() {
        return new Route(FIRST_STOP, SECOND_STOP, ANY_STOP);
    }


}
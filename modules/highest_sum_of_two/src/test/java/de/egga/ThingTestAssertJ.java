package de.egga;

import org.junit.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

public class ThingTestAssertJ {

    // An array of positive integers is given. Implement a function that
    // returns the smallest sum of pairs in the array

    @Test(expected = IllegalArgumentException.class)
    public void it_should_not_accept_less_than_four_elements() {
        int[] chain = new int[]{1, 3};
        int sum = Thing.smallestSum(chain);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void it_should_call_for_action() {
        int[] chain = new int[]{1, 1, 69, 4, 4, 3};
        int sum = Thing.smallestSum(chain);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void it_should_call_for_action3() {
        int[] chain = new int[]{2, 1, 4, 5};
        int sum = Thing.smallestSum(chain);
        assertThat(sum).isEqualTo(5);
    }

    @Test
    public void it_should_call_for_actio3n() {
        int[] chain = new int[]{3, 9, 6, 4};
        int sum = Thing.smallestSum(chain);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void it_should_call_for_actio8n() {
        int[] chain = new int[]{0, 1, 2, 3, 9, 6, 4, 7};
        int sum = Thing.smallestSum(chain);
        assertThat(sum).isEqualTo(3);
    }


}
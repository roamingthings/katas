package de.egga;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LightTest {

    @Test
    public void new_light_should_have_brightness_of_zero() {
        Light light = new Light();
        int brightness = light.getBrightness();
        assertThat(brightness).isEqualTo(0);
    }

    @Test
    public void turned_on_light_should_have_brightness_of_one() {
        Light light = new Light();
        light.turnOn();
        assertThat(light.getBrightness()).isEqualTo(1);
    }

    @Test
    public void turned_off_light_should_have_brightness_of_one() {
        Light light = new Light();
        light.turnOn();
        light.turnOff();
        assertThat(light.getBrightness()).isEqualTo(0);
    }

    @Test
    public void turned_on_light_should_toggle_to_brightness_zero() {
        Light light = new Light();
        light.turnOn();
        light.toggle();
        assertThat(light.getBrightness()).isEqualTo(0);
    }

    @Test
    public void turned_off_light_should_toggle_to_brightness_one() {
        Light light = new Light();
        light.toggle();
        assertThat(light.getBrightness()).isEqualTo(1);
    }
}
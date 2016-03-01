package de.egga.race_cars._001.tire_pressure;

import org.junit.*;

import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
}

package de.egga.tire_pressure;

import org.junit.*;

import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void foo() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
}

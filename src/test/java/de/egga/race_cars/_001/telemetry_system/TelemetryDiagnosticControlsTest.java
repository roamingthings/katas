package de.egga.race_cars._001.telemetry_system;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TelemetryDiagnosticControlsTest {

    @Mock Client client;
    @InjectMocks TelemetryDiagnosticControls controls;

    @Test
    public void it_should_receive_status_message_from_client() throws Exception {
        when(client.getOnlineStatus()).thenReturn(true);
        when(client.receive()).thenReturn("some answer");
        controls.checkTransmission();
        assertThat(controls.getDiagnosticInfo()).isEqualTo("some answer");
    }

    @Test(expected = Exception.class)
    public void it_should_throw_exception_when_unable_to_connect() throws Exception {
        when(client.getOnlineStatus()).thenReturn(false);
        controls.checkTransmission();
    }

    @Test
    public void it_should_disconnect() throws Exception {
        when(client.getOnlineStatus()).thenReturn(true);
        controls.checkTransmission();
        Mockito.verify(client).disconnect();
    }

    @Test
    public void it_should_take_diagnostic_info_from_strangers() {
        controls.setDiagnosticInfo("blargel");
        assertThat(controls.getDiagnosticInfo()).isEqualTo("blargel");
    }
}
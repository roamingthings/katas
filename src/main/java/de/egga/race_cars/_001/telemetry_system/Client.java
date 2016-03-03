package de.egga.race_cars._001.telemetry_system;

public interface Client {
    boolean getOnlineStatus();

    void connect(String telemetryServerConnectionString);

    void disconnect();

    void send(String message);

    String receive();
}

package daneker.code.server;


import com.fasterxml.jackson.annotation.JsonCreator;

public class measurementDTO {


    private Double value;
    private Boolean isRaining;
    private sensorDTO sensor;

    public measurementDTO() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Boolean getRaining() {
        return isRaining;
    }

    public void setRaining(Boolean raining) {
        isRaining = raining;
    }

    public sensorDTO getSensor() {
        return sensor;
    }

    public void setSensor(sensorDTO sensor) {
        this.sensor = sensor;
    }

    @Override
    public String toString() {
        return
                "value=" + value +
                ", isRaining=" + isRaining +
                ", sensor=" + sensor.getName();

    }
}

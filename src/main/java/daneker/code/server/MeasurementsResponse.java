package daneker.code.server;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MeasurementsResponse {
    private List<measurementDTO> measurements;


    public MeasurementsResponse(List<measurementDTO> measurements) {
        this.measurements = measurements;
    }
    public MeasurementsResponse() {
    }

    public List<measurementDTO> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<measurementDTO> measurements) {
        this.measurements = measurements;
    }
}

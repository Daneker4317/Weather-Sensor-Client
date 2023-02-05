package daneker.code.server;



public class sensorDTO {
    private String name;

    public sensorDTO(String name) {
        this.name = name;
    }
    public sensorDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

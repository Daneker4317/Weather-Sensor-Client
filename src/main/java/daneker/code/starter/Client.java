package daneker.code.starter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        final String sensor = "test_77";
        registerSensor(sensor);

        Random random = new Random();

        double minTemp = 0.0;
        double maxTemp = 45.0;

        for (int i = 0; i < 50; i++) {
            System.out.println(i);
            sendMeasurement(random.nextDouble() * maxTemp , random.nextBoolean() , sensor);
        }
    }
    private static void registerSensor(String sensor){
        final String URL = "http://localhost:8080/sensors/add";
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("name" ,sensor);

        makePostRequestWithJSONData(URL , jsonData);

    }
    private static void sendMeasurement(double value , boolean raining , String sensor){
        final String URL = "http://localhost:8080/measurements/add";

        Map<String , Object> jsonData  = new HashMap<>();

        jsonData.put("value" , value);
        jsonData.put("raining", raining);
        jsonData.put("sensor" , Map.of("name" , sensor));
        makePostRequestWithJSONData(URL , jsonData);

    }


    private static void makePostRequestWithJSONData(String URL , Map<String , Object>jsonData){
        final RestTemplate restTemplate = new RestTemplate();

        final HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(jsonData , httpHeaders);

        try {
            restTemplate.postForObject(URL , request , String.class);
            System.out.println("success request");
        }catch (HttpClientErrorException exception){
            System.out.println("ERROR");
            System.out.println(exception.getMessage());
        }

    }



}

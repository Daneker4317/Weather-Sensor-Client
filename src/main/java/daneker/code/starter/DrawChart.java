package daneker.code.starter;

import daneker.code.server.MeasurementsResponse;
import daneker.code.server.measurementDTO;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawChart {
    public static void main(String[] args) {
        drawChart(getTemperaturesFromServer());
    }
    private static List<Double> getTemperaturesFromServer() {
        final RestTemplate restTemplate = new RestTemplate();
        final String url = "http://localhost:8080/measurements";


        MeasurementsResponse measurementsResponse = restTemplate.getForObject(url, MeasurementsResponse.class);
        measurementsResponse.getMeasurements().forEach(System.out::println);

        if (measurementsResponse == null || measurementsResponse.getMeasurements() == null) {
            return Collections.emptyList();
        }

        return measurementsResponse.getMeasurements().stream().map(measurementDTO::getValue).collect(Collectors.toList());
    }

    private static void drawChart(List<Double> temperatures) {
        double[] xData = IntStream.range(0, temperatures.size()).asDoubleStream().toArray();
        double[] yData = temperatures.stream().mapToDouble(x -> x).toArray();

        XYChart chart = QuickChart.getChart("Temperatures", "X", "Y", "temperature", xData, yData);

        new SwingWrapper(chart).displayChart();
    }
}

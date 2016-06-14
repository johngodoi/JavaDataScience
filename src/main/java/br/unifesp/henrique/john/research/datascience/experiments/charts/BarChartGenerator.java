package br.unifesp.henrique.john.research.datascience.experiments.charts;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by john on 13/06/16.
 */
public class BarChartGenerator {
    public List<Point> generatePoints(Map<String, Long> counts) {
        List<Point> points = counts.entrySet().stream()
                .map(point -> new Point(point.getKey(), point.getValue().doubleValue()))
                .collect(Collectors.toList());
        return points;
    }
}

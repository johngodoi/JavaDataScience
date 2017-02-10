package br.unifesp.henrique.john.research.datascience.charts;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by john on 13/06/16.
 */
public class BarChartGenerator implements IChartGenerator {
    private List<Point> points;
    private String title;
    private String xAxisLabel;
    private AxisChartTypes xAxisType;
    private String yAxisLabel;
    private AxisChartTypes yAxisType;
    private List<HorizontalConstantLineMarker> horizontalConstantLineMarkers = Lists.newArrayList();
    private List<VerticalConstantLineMarker> verticalConstantLineMarkers = Lists.newArrayList();

    public BarChartGenerator generatePoints(Map<String, Long> counts) {
        this.points = counts.entrySet().stream()
                .map(point -> new Point(point.getKey(), point.getValue().doubleValue()))
                .collect(Collectors.toList());
        return this;
    }

    public List<Point> getPoints() {
        return points;
    }

    public BarChartGenerator setTitle(String title) {
        this.title = title;
        return this;
    }

    public BarChartGenerator setXAxisLabel(String label) {
        this.xAxisLabel = label;
        return this;
    }

    public BarChartGenerator setXAxisType(AxisChartTypes type) {
        this.xAxisType = type;
        return this;
    }

    public BarChartGenerator setYAxisLabel(String label) {
        this.yAxisLabel = label;
        return this;
    }

    public BarChartGenerator setYAxisType(AxisChartTypes type) {
        this.yAxisType = type;
        return this;
    }

    @Override
    public void show() {
        BarChartViewer.view(new String[0], this);
    }

    public String getXAxisLabel() {
        return xAxisLabel;
    }

    public String getYAxisLabel() {
        return yAxisLabel;
    }

    public AxisChartTypes getXAxisType() {
        return xAxisType;
    }

    public AxisChartTypes getYAxisType() {
        return yAxisType;
    }

    public String getTitle() {
        return title;
    }

    public List<HorizontalConstantLineMarker> getHorizontalConstantLineMarkers() {
        return horizontalConstantLineMarkers;
    }

    public BarChartGenerator addHorizontalConstantLineMarker(Double value) {
        this.horizontalConstantLineMarkers.add(new HorizontalConstantLineMarker(value));
        return this;
    }

    public List<VerticalConstantLineMarker> getVerticalConstantLineMarkers() {
        return verticalConstantLineMarkers;
    }

    public BarChartGenerator addVerticalConstantLineMarker(Double value) {
        this.verticalConstantLineMarkers.add(new VerticalConstantLineMarker(value));
        return this;
    }
}

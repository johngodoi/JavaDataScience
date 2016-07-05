package br.unifesp.henrique.john.research.datascience.charts;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by john on 14/06/16.
 */
public class BarChartViewer extends Application {

    public static final String FORMAT_NAME = "jpg";
    private static BarChartGenerator barChartGenerator; //hardcode
    private Axis yAxis;
    private Axis xAxis;
    private Line[] horizontalMarkers;

    public static void view(String[] args, final BarChartGenerator barChartGenerator){
        BarChartViewer.barChartGenerator = barChartGenerator;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        initializeMarkers();
        stage.setTitle(barChartGenerator.getTitle());
        BarChart<String, Number> chart = generateChart();
        Node chartArea = chart.lookup(".chart-plot-background");

        Pane pane = new Pane();
        pane.getChildren().add(chart);
        pane.getChildren().addAll(horizontalMarkers);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        double value = 5;

        // find chart area Node
        Bounds chartAreaBounds = chartArea.localToScene(chartArea.getBoundsInLocal());
        createHorizontalMarker(barChartGenerator.getHorizontalConstantLineMarkers(), chartAreaBounds);

        saveAsJPG(chart,barChartGenerator.getTitle());
    }

    private void initializeMarkers() {
        horizontalMarkers = new Line[barChartGenerator.getHorizontalConstantLineMarkers().size()];
        for (int i = 0; i < horizontalMarkers.length; i++) {
            horizontalMarkers[i] = new Line();
        }
    }

    private void createHorizontalMarker(List<HorizontalConstantLineMarker> value, Bounds chartAreaBounds) {
        for (int i = 0; i < value.size(); i++) {
            Line line = horizontalMarkers[i];

            // remember scene position of chart area
            double yShift = chartAreaBounds.getMinY();
            // set x parameters of the horizontalMarkers to chart area bounds
            line.setStartX(chartAreaBounds.getMinX());
            line.setEndX(chartAreaBounds.getMaxX());
            double displayPosition = yAxis.getDisplayPosition(value.get(i).getValue());
            // update marker
            line.setStartY(yShift + displayPosition);
            line.setEndY(yShift + displayPosition);
        }
    }

    public BarChart<String, Number> generateChart() {
        this.xAxis = generateAxis(barChartGenerator.getXAxisType());
        this.yAxis = generateAxis(barChartGenerator.getYAxisType());

        XYChart.Series series = new XYChart.Series();
        for (Point point : barChartGenerator.getPoints()){
            series.getData().add(new XYChart.Data(point.getName(),point.getValue()));
        }
        final BarChart<String,Number> bc = new BarChart(xAxis,yAxis);
        bc.getData().add(series);
        bc.setTitle(barChartGenerator.getTitle());
        return bc;
    }

    private Axis generateAxis(AxisChartTypes xAxisType) {
        if(AxisChartTypes.Category.equals(xAxisType)) {
            final CategoryAxis axis = new CategoryAxis();
            axis.setLabel(barChartGenerator.getXAxisLabel());
            return axis;
        } else {
            final NumberAxis axis = new NumberAxis();
            axis.setLabel(barChartGenerator.getYAxisLabel());
            return axis;
        }
    }


    public void saveAsJPG(Chart lineChart, String path) {
        WritableImage image = lineChart.snapshot(new SnapshotParameters(), null);
        File file = new File(path+"."+ FORMAT_NAME);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), FORMAT_NAME, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

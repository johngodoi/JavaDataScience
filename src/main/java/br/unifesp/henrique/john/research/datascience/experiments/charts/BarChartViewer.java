package br.unifesp.henrique.john.research.datascience.experiments.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;

/**
 * Created by john on 14/06/16.
 */
public class BarChartViewer extends Application {

    private static BarChartGenerator barChartGenerator; //hardcode

    public static void view(String[] args, final BarChartGenerator barChartGenerator){
        BarChartViewer.barChartGenerator = barChartGenerator;
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle(barChartGenerator.getTitle());
        Scene scene  = new Scene(generateChart(),800,600);
        stage.setScene(scene);
        stage.show();
    }

    public BarChart<String, Number> generateChart() {
        final Axis xAxis = generateAxis(barChartGenerator.getXAxisType());
        final Axis yAxis = generateAxis(barChartGenerator.getYAxisType());
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
}

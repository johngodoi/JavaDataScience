package br.unifesp.henrique.john.research.datascience.charts;

import br.unifesp.henrique.john.research.datascience.assertion.chart.PointsAssertion;
import br.unifesp.henrique.john.research.datascience.utils.ConstantValues;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by john on 13/06/16.
 */
public class BarChartGeneratorTest {

    private HashMap<String, Long> counts;

    @Before
    public void setUp() throws Exception {
        counts = new HashMap<>();
        counts.put("John",4l);
        counts.put("Maria",2l);
        counts.put("Joaquim",1l);
        counts.put("Marcia",1l);
        counts.put("Diane",10l);
        counts.put("Vitor",1l);
    }

    @Test
    public void generatePoints() throws Exception {
        BarChartGenerator chartGenerator = new BarChartGenerator()
                .generatePoints(counts)
                .setXAxisLabel("occurrences").setXAxisType(AxisChartTypes.Category)
                .setYAxisLabel("names").setYAxisType(AxisChartTypes.Number)
                .setTitle("Authors Frequency");
        List<Point> points =
                chartGenerator.getPoints();
        PointsAssertion pointsAssertion = PointsAssertion.assertPoints(points).hasQtt(6);
        pointsAssertion.assertPointFor("John").hasName("John").hasValue(4);
        pointsAssertion.assertPointFor("Maria").hasName("Maria").hasValue(2);
        pointsAssertion.assertPointFor("Joaquim").hasName("Joaquim").hasValue(1);
        pointsAssertion.assertPointFor("Marcia").hasName("Marcia").hasValue(1);
        pointsAssertion.assertPointFor("Diane").hasName("Diane").hasValue(10);
        pointsAssertion.assertPointFor("Vitor").hasName("Vitor").hasValue(1);

        //chartGenerator.show();
    }

    @Test
    public void add1HorizontalConstantLineMarker() throws Exception {

        BarChartGenerator chartGenerator = new BarChartGenerator()
                .generatePoints(counts)
                .setTitle("1 HorizontalConstantLineMarker")
                .setXAxisLabel("occurrences").setXAxisType(AxisChartTypes.Category)
                .setYAxisLabel("names").setYAxisType(AxisChartTypes.Number)
                .addHorizontalConstantLineMarker(3.5);

        List<HorizontalConstantLineMarker> horizontalConstantLineMarkers = chartGenerator.getHorizontalConstantLineMarkers();
        assertEquals("Valor de marcador horizontal", 3.5, horizontalConstantLineMarkers.get(0).getValue(), ConstantValues.precision);

        //chartGenerator.show();
    }

    @Test
    public void add3HorizontalConstantLineMarkers() throws Exception {

        BarChartGenerator chartGenerator = new BarChartGenerator()
                .generatePoints(counts)
                .setTitle("1 HorizontalConstantLineMarker")
                .setXAxisLabel("occurrences").setXAxisType(AxisChartTypes.Category)
                .setYAxisLabel("names").setYAxisType(AxisChartTypes.Number)
                .addHorizontalConstantLineMarker(3.)
                .addHorizontalConstantLineMarker(3.5)
                .addHorizontalConstantLineMarker(2.5);

        List<HorizontalConstantLineMarker> horizontalConstantLineMarkers = chartGenerator.getHorizontalConstantLineMarkers();
        assertEquals("Valor de marcador horizontal", 3., horizontalConstantLineMarkers.get(0).getValue(), ConstantValues.precision);
        assertEquals("Valor de marcador horizontal", 3.5, horizontalConstantLineMarkers.get(1).getValue(), ConstantValues.precision);
        assertEquals("Valor de marcador horizontal", 2.5, horizontalConstantLineMarkers.get(2).getValue(), ConstantValues.precision);

        //chartGenerator.show();
    }

}

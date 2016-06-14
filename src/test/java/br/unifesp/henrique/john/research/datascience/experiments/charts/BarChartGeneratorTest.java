package br.unifesp.henrique.john.research.datascience.experiments.charts;

import br.unifesp.henrique.john.research.datascience.experiments.articles.AuthorNamesProcessor;
import br.unifesp.henrique.john.research.datascience.experiments.assertion.PointsAssertion;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        counts.put("Diane",1l);
        counts.put("Vitor",1l);
    }

    @Test
    public void generatePoints() throws Exception {
        BarChartGenerator chartGenerator = new BarChartGenerator();
        List<Point> points = chartGenerator.generatePoints(counts);
        PointsAssertion pointsAssertion = PointsAssertion.assertPoints(points).hasQtt(6);
        pointsAssertion.assertPointFor("John").hasName("John").hasValue(4);
        pointsAssertion.assertPointFor("Maria").hasName("Maria").hasValue(2);
        pointsAssertion.assertPointFor("Joaquim").hasName("Joaquim").hasValue(1);
        pointsAssertion.assertPointFor("Marcia").hasName("Marcia").hasValue(1);
        pointsAssertion.assertPointFor("Diane").hasName("Diane").hasValue(1);
        pointsAssertion.assertPointFor("Vitor").hasName("Vitor").hasValue(1);
    }
}

package br.unifesp.henrique.john.research.datascience.experiments.charts;

import br.unifesp.henrique.john.research.datascience.experiments.articles.AuthorNamesProcessor;
import br.unifesp.henrique.john.research.datascience.experiments.assertion.PointsAssertion;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by john on 13/06/16.
 */
public class BarChartGeneratorTest {
    @Test
    public void generatePoints() throws Exception {
        AuthorNamesProcessor processor = new AuthorNamesProcessor();
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim D Maria John+Márcia Y John D Diane&Vitor John Maria K");
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

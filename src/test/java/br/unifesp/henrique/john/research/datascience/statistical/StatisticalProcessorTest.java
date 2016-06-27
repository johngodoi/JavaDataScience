package br.unifesp.henrique.john.research.datascience.statistical;

import br.unifesp.henrique.john.research.datascience.utils.ConstantValues;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by john on 13/06/16.
 */
public class StatisticalProcessorTest {
    @Test
    public void calculateAverage() {
        final double average = StatisticalProcessor.calculateAverage(4, 2, 1, 1, 1, 1);
        assertEquals("", 1.66667, average, ConstantValues.precision);
    }

    @Test
    public void calculateVariance() {
        final double variance = StatisticalProcessor.calculateVariance(4, 2, 1, 1, 1, 1);
        assertEquals("", 1.22222, variance, ConstantValues.precision);
    }

    @Test
    public void calculateStandardDeviation() {
        final double stdDeviation = StatisticalProcessor.calculateStandardDeviation(4, 2, 1, 1, 1, 1);
        assertEquals("", 1.10554, stdDeviation, ConstantValues.precision);
    }

    @Test
    public void findMinValue() throws Exception {
        final double min = StatisticalProcessor.findMinValue(4, 2, 1, 1, 1, 1);
        assertEquals("", 1., min, ConstantValues.precision);
    }

    @Test
    public void findMaxValue() throws Exception {
        final double max = StatisticalProcessor.findMaxValue(4, 2, 1, 1, 1, 1);
        assertEquals("", 4., max, ConstantValues.precision);
    }

    @Test
    public void calculateEuclideanDistance() throws Exception {
        final double covariance = StatisticalProcessor.calculateEuclideanDistance(new double[]{4, 2, 1, 1, 1, 1},new double[]{4, 2, 1, 1, 1, 1});
        assertEquals("", 0.40824, covariance, ConstantValues.precision);
    }
}

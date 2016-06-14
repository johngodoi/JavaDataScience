package br.unifesp.henrique.john.research.datascience.experiments.statistical;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by john on 13/06/16.
 */
public class StatisticalProcessorTest {
    @Test
    public void calculateAverage(){
        final double average = StatisticalProcessor.calculateAverage(4,2,1,1,1,1);
        assertEquals("",1.66667,average, 0.00001);
    }

    @Test
    public void calculateVariance(){
        final double variance = StatisticalProcessor.calculateVariance(4,2,1,1,1,1);
        assertEquals("",1.22222,variance, 0.00001);
    }

    @Test
    public void calculateStandardDeviation(){
        final double stdDeviation = StatisticalProcessor.calculateStandardDeviation(4,2,1,1,1,1);
        assertEquals("",1.10554,stdDeviation,0.00001);
    }
}

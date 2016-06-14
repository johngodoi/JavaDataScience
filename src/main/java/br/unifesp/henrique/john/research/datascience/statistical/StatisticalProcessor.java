package br.unifesp.henrique.john.research.datascience.statistical;

import java.util.stream.DoubleStream;

/**
 * Created by john on 13/06/16.
 */
public class StatisticalProcessor {
    public static double calculateAverage(double ...values) {
        return DoubleStream.of(values).average().getAsDouble();
    }

    public static double calculateStandardDeviation(double ...values) {
        return Math.sqrt(calculateVariance(values));
    }

    public static double calculateVariance(double ...values) {
        double average = calculateAverage(values);
        return DoubleStream.of(values).map(p ->  Math.pow((p - average),2)).sum()/values.length;
    }
}

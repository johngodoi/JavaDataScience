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

    public static double findMinValue(double ...values) {
        return DoubleStream.of(values).min().getAsDouble();
    }

    public static double findMaxValue(double ...values) {
        return DoubleStream.of(values).max().getAsDouble();
    }

    public static double calculateEuclideanDistance(double[] array1, double[] array2) {
        double averageArray1 = calculateAverage(array1);
        double averageArray2 = calculateAverage(array2);
        double sumDifferences = 0.;
        for (int i = 0; i < array1.length; i++) {
            sumDifferences += Math.pow(array1[i]-array2[i],2.);
        }
        return Math.sqrt(sumDifferences/array1.length);
    }
}

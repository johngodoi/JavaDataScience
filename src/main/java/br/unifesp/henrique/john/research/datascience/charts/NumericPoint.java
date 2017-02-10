package br.unifesp.henrique.john.research.datascience.charts;

/**
 * Created by john on 13/06/16.
 */
public class NumericPoint {
    private double name;
    private double value;

    public NumericPoint(double name, double value) {
        this.name=name;
        this.value=value;
    }

    public double getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}

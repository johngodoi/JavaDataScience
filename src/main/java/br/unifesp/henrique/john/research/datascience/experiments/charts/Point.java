package br.unifesp.henrique.john.research.datascience.experiments.charts;

/**
 * Created by john on 13/06/16.
 */
public class Point {
    private String name;
    private double value;

    public Point(String name, double value) {
        this.name=name;
        this.value=value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }
}

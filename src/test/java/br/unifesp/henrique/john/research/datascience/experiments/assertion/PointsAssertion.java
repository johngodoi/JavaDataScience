package br.unifesp.henrique.john.research.datascience.experiments.assertion;

import br.unifesp.henrique.john.research.datascience.experiments.charts.Point;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class PointsAssertion {
    private final List<Point> points;

    public PointsAssertion(List<Point> points) {
        this.points = points;
    }

    public static PointsAssertion assertPoints(List<Point> points) {
        return new PointsAssertion(points);
    }

    public PointsAssertion hasQtt(int qtt) {
        assertEquals("Quantidade de pontos", qtt, points.size());
        return this;
    }

    public PointAssertion assertPointFor(String nome) {
        Point pointForName = points.stream().filter(point -> point.getName().equals(nome)).findAny().get();
        return new PointAssertion(pointForName);
    }
}

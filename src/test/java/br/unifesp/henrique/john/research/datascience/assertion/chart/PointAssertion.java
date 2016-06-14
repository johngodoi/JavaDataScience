package br.unifesp.henrique.john.research.datascience.assertion.chart;

import br.unifesp.henrique.john.research.datascience.charts.Point;
import br.unifesp.henrique.john.research.datascience.utils.ConstantValues;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class PointAssertion {
    private final Point point;

    public PointAssertion(Point point) {
        this.point = point;
    }

    public PointAssertion hasName(String name) {
        assertEquals("Nome do ponto", name, point.getName());
        return this;
    }

    public PointAssertion hasValue(double value) {
        assertEquals("Valor do ponto", value, point.getValue(), ConstantValues.precision);
        return this;
    }
}

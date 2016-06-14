package br.unifesp.henrique.john.research.datascience.experiments.charts;

import br.unifesp.henrique.john.research.datascience.experiments.articles.AuthorNamesProcessor;
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
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim D Maria John+Márcia Y John D Letícia&Vitor John Maria K");
        BarChartGenerator chartGenerator = new BarChartGenerator();
        List<Point> points = chartGenerator.generatePoints(counts);
        assertEquals("Quantidade de ocorrências para John", 4, points.get(0).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para John", "John", points.get(0).getName());
        assertEquals("Quantidade de ocorrências para Maria", 2, points.get(1).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para Maria", "Maria", points.get(1).getName());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, points.get(2).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para Joaquim", "Joaquim", points.get(2).getName());
        assertEquals("Quantidade de ocorrências para Marcia", 1, points.get(3).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para Marcia", "Marcia", points.get(3).getName());
        assertEquals("Quantidade de ocorrências para Leticia", 1, points.get(4).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para Leticia", "Leticia", points.get(4).getName());
        assertEquals("Quantidade de ocorrências para Vitor", 1, points.get(5).getValue(), 0.00001);
        assertEquals("Quantidade de ocorrências para Vitor", "Vitor", points.get(5).getName());
        
    }
}

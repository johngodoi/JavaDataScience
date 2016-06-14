package br.unifesp.henrique.john.research.datascience.experiments.articles;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class AuthorNamesProcessorTest {

    private AuthorNamesProcessor processor;

    @Before
    public void setUp() throws Exception {
        processor = new AuthorNamesProcessor();
    }

    @Test
    public void countAuthorNamesOccurrences(){
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim Maria John Márcia John Diane Vitor John Maria");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane").longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countAuthorNamesOccurrencesWithoutSpecials(){
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim Maria John+Márcia John Diane&Vitor John Maria");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane").longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countOnlyAuthorWithAtLeastTwoLettersName(){
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim D Maria John+Márcia Y John D Diane&Vitor John Maria K");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane").longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor").longValue());
    }
}

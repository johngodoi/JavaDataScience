package br.unifesp.henrique.john.research.datascience.articles;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class WordProcessorTest {

    private WordProcessor processor;

    @Before
    public void setUp() throws Exception {
        processor = new WordProcessor();
    }

    @Test
    public void countAuthorNamesOccurrences(){
        Map<String, Long> counts = processor.countNamesOccurrences("John Joaquim Maria John Márcia John Diane Vitor John Maria");
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
        Map<String, Long> counts = processor.countNamesOccurrences("John Joaquim Maria John+Márcia John Diane&Vitor John Maria");
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
        Map<String, Long> counts = processor.countNamesOccurrences("John Joaquim D Maria John+Márcia Y John D Diane&Vitor John Maria K");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane").longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countArticlesNamesOccurrences(){
        ArrayList<String> words = Lists.newArrayList("Journal International of", "Forensics Journal", "Journal International of");
        Map<String, Long> counts = processor.countWordsOccurrences(words);
        assertEquals("Quantidade de palavras encontradas", 2, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para 'Journal International of'", 2, counts.get("Journal International of").longValue());
        assertEquals("Quantidade de ocorrências para 'Forensics Journal'", 1, counts.get("Forensics Journal").longValue());
    }
}

package br.unifesp.henrique.john.research.datascience.experiments.articles;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class AuthorNamesProcessorTest {

    @Test
    public void countAuthorNamesOccurrences(){
        AuthorNamesProcessor processor = new AuthorNamesProcessor();
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim Maria John Márcia John Letícia Vitor John Maria");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Leticia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countAuthorNamesOccurrencesWithoutSpecials(){
        AuthorNamesProcessor processor = new AuthorNamesProcessor();
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim Maria John+Márcia John Letícia&Vitor John Maria");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Leticia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countOnlyAuthorWithAtLeastTwoLettersName(){
        AuthorNamesProcessor processor = new AuthorNamesProcessor();
        Map<String, Long> counts = processor.countWordsOccurrences("John Joaquim D Maria John+Márcia Y John D Letícia&Vitor John Maria K");
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Leticia").longValue());
        assertEquals("Quantidade de ocorrências para John", 1, counts.get("Vitor").longValue());
    }
    //não contar palavras com apenas uma letra
    //
}

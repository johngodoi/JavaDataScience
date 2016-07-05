package br.unifesp.henrique.john.research.datascience.words;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static junit.framework.TestCase.assertFalse;
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
        Map<String, Long> counts = processor.countNamesOccurrences("John, Joaquim, Maria, John, Márcia, John, Diane, Vitor, John, Maria", false, false);
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim").longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia").longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane").longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor").longValue());
    }

    @Test
    public void countAuthorNamesOccurrencesIgnoringCase(){
        Map<String, Long> counts = processor.countNamesOccurrences("John, Joaquim, Maria, john, Márcia, john, Diane, Vitor, John, Maria",true, false);
        assertEquals("Quantidade de palavras encontradas", 6, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 4, counts.get("John".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Maria", 2, counts.get("Maria".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Marcia", 1, counts.get("Marcia".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Diane", 1, counts.get("Diane".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Vitor", 1, counts.get("Vitor".toLowerCase()).longValue());
    }

    @Test
    public void countAuthorNamesTogetherToSurnameOccurrences(){
        Map<String, Long> counts = processor.countNamesOccurrences("John Godoi, Joaquim XY, Maria El, John Godoi", false, false);
        assertEquals("Quantidade de palavras encontradas", 3, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("John Godoi").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 1, counts.get("Maria El").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim XY").longValue());
    }

    @Test
    public void countAuthorNamesTogetherToSurnameOccurrencesFromList(){
        ArrayList<String> names = Lists.newArrayList("John Godoi, Joaquim XY", "Maria El, John Godoi");
        Map<String, Long> counts = processor.splitAndCountWordsOccurrences(names,",",false, false);
        assertEquals("Quantidade de palavras encontradas", 3, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("John Godoi").longValue());
        assertEquals("Quantidade de ocorrências para Maria", 1, counts.get("Maria El").longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim XY").longValue());
    }

    @Test
    public void countAuthorNamesTogetherToSurnameOccurrencesFromListIgnoringCase(){
        ArrayList<String> names = Lists.newArrayList("John Godoi, Joaquim XY", "Maria El, john godoi");
        Map<String, Long> counts = processor.splitAndCountWordsOccurrences(names,",",true, false);
        assertEquals("Quantidade de palavras encontradas", 3, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para John", 2, counts.get("John Godoi".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Maria", 1, counts.get("Maria El".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para Joaquim", 1, counts.get("Joaquim XY".toLowerCase()).longValue());
    }

    @Test
    public void countAuthorNamesOccurrencesWithoutSpecials(){
        Map<String, Long> counts = processor.countNamesOccurrences("John, Joaquim, Maria, John,+Márcia, John, Diane,&Vitor, John, Maria", false, false);
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
        Map<String, Long> counts = processor.countNamesOccurrences("John, Joaquim, D, Maria, John,+Márcia, Y, John, D, Diane,&Vitor, John, Maria, K", false, false);
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
        Map<String, Long> counts = processor.countWordsOccurrences(words,false, false);
        assertEquals("Quantidade de palavras encontradas", 2, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para 'Journal International of'", 2, counts.get("Journal International of").longValue());
        assertEquals("Quantidade de ocorrências para 'Forensics Journal'", 1, counts.get("Forensics Journal").longValue());
    }

    @Test
    public void countArticlesNamesOccurrencesIgnoringCase(){
        ArrayList<String> words = Lists.newArrayList("Journal International of", "Forensics Journal", "journal international of");
        Map<String, Long> counts = processor.countWordsOccurrences(words,true, false);
        assertEquals("Quantidade de palavras encontradas", 2, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para 'Journal International of'", 2, counts.get("Journal International of".toLowerCase()).longValue());
        assertEquals("Quantidade de ocorrências para 'Forensics Journal'", 1, counts.get("Forensics Journal".toLowerCase()).longValue());
    }

    @Test
    public void countArticlesNamesOccurrencesIgnoringStopWords(){
        ArrayList<String> words = Lists.newArrayList("Journal","of","International","Journal","Proceedings","the","Forensics");
        Map<String, Long> counts = processor.countWordsOccurrences(words,false, true);
        assertEquals("Quantidade de palavras encontradas", 4, counts.keySet().size());
        assertEquals("Quantidade de ocorrências para 'Journal'", 2, counts.get("Journal").longValue());
        assertEquals("Quantidade de ocorrências para 'Forensics'", 1, counts.get("Forensics").longValue());
        assertEquals("Quantidade de ocorrências para 'Proceedings'", 1, counts.get("Proceedings").longValue());
        assertEquals("Quantidade de ocorrências para 'International'", 1, counts.get("International").longValue());
        assertFalse("Não contêm ocorrências para 'of'", counts.keySet().contains("of"));
        assertFalse("Não contêm ocorrências para 'the'", counts.keySet().contains("the"));
    }
}

package br.unifesp.henrique.john.research.datascience.words;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class WordProcessor {

    private final int minimumOfCharsToConsiderWord = 2;

    public Map<String, Long> countNamesOccurrences(String names, boolean ignoreCase) {
        String normalized = normalizeString(names);
        List<String> nameList = splitWords(normalized,",");
        return countWordsOccurrences(nameList, ignoreCase);
    }

    public Map<String, Long> splitAndCountWordsOccurrences(List<String> words, String charToSplit, boolean ignoreCase) {
        String allWords = "";
        for(String author:words){
            allWords+=(charToSplit+author);
        }
        String normalized = normalizeString(allWords);
        List<String> names = splitWords(normalized,charToSplit);
        return countWordsOccurrences(names, ignoreCase);
    }

    public Map<String, Long> countWordsOccurrences(List<String> words, boolean ignoreCase) {
        Stream<String> wordsStream = words.stream().map(String::trim);
        if(ignoreCase) wordsStream = wordsStream.map(String::toLowerCase);
        Map<String, Long> streamResults = wordsStream.collect(Collectors.groupingBy(p -> (p!=null)?p.toString():"", Collectors.counting()));
        return streamResults;
    }

    private List<String> splitWords(String normalized, String charToSplit) {
        return Stream.of(normalized.split(charToSplit)).filter(p -> p.length() > minimumOfCharsToConsiderWord)
                .collect(Collectors.toCollection(ArrayList<String>::new));
    }

    private String normalizeString(String input) {
        CharSequence src = new StringBuilder(input);
        return Normalizer.normalize(src, Normalizer.Form.NFKD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "")
                .replaceAll("[^a-zA-Z0-9, ]", " ");
    }
}

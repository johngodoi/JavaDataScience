package br.unifesp.henrique.john.research.datascience.articles;

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
    public Map<String, Long> countNamesOccurrences(String names) {
        String normalized = normalizeString(names);
        List<String> nameList = filterByNames(normalized);
        return countWordsOccurrences(nameList);
    }

    public Map<String, Long> countNamesOccurrences(List<String> nameList) {
        String allAuthors = "";
        for(String author:nameList){
            allAuthors+=(","+author);
        }
        String normalized = normalizeString(allAuthors);
        List<String> names = filterByNames(normalized);
        return countWordsOccurrences(names);
    }

    public Map<String, Long> countWordsOccurrences(List<String> words) {
        Map<String, Long> streamResults = words.stream().map(String::trim).collect(Collectors.groupingBy(p -> (p!=null)?p.toString():"", Collectors.counting()));
        return streamResults;
    }

    private List<String> filterByNames(String normalized) {
        return Stream.of(normalized.split(",")).filter(p -> p.length()>2).collect(Collectors.toCollection(ArrayList<String>::new));
    }

    private String normalizeString(String input) {
        CharSequence src = new StringBuilder(input);
        return Normalizer.normalize(src, Normalizer.Form.NFKD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "")
                .replaceAll("[^a-zA-Z0-9, ]", " ");
    }
}

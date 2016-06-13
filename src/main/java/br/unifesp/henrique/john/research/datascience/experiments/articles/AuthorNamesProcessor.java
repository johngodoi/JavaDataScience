package br.unifesp.henrique.john.research.datascience.experiments.articles;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class AuthorNamesProcessor {
    public Map<String, Long> countWordsOccurrences(String input) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        String normalized = normalizeString(input);
        String[] words = normalized.split(" ");
        Map<String, Long> streamResults = Stream.of(words)
                .filter(p -> p.length()>1)
                .collect(Collectors.groupingBy(p -> p.toString(), Collectors.counting()));
        return streamResults;
    }

    private String normalizeString(String input) {
        CharSequence src = new StringBuilder(input);
        return Normalizer.normalize(src, Normalizer.Form.NFKD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "")
                .replaceAll("[^a-zA-Z0-9 ]", " ");
    }
}

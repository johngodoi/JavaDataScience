package br.unifesp.henrique.john.research.datascience.experiments.articles;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class AuthorNamesProcessor {
    public Map<String, Long> countWordsOccurrences(String input) {
        String normalized = normalizeString(input);
        List<String> names = filterByNames(normalized);
        Map<String, Long> streamResults = names.stream().collect(Collectors.groupingBy(p -> p.toString(), Collectors.counting()));
        return streamResults;
    }

    private List<String> filterByNames(String normalized) {
        return Stream.of(normalized.split(" ")).filter(p -> p.length()>1).collect(Collectors.toCollection(ArrayList<String>::new));
    }

    private String normalizeString(String input) {
        CharSequence src = new StringBuilder(input);
        return Normalizer.normalize(src, Normalizer.Form.NFKD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "")
                .replaceAll("[^a-zA-Z0-9 ]", " ");
    }
}

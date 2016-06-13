package br.unifesp.henrique.john.research.datascience.experiments.articles;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lab-Eletrofisio on 13/06/2016.
 */
public class AuthorNamesProcessor {
    public Map<String, Integer> countWordsOccurrences(String input) {
        Map<String, Integer> counts = new HashMap<String, Integer>();
        String normalized = normalizeString(input);
        String[] words = normalized.split(" ");
        for (String word: words){
            if (word.length() < 2) continue;
            if(counts.containsKey(word)){
                counts.put(word,counts.get(word)+1);
            } else {
                counts.put(word,1);
            }
        }
        return counts;
    }

    private String normalizeString(String input) {
        CharSequence src = new StringBuilder(input);
        return Normalizer.normalize(src, Normalizer.Form.NFKD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}", "")
                .replaceAll("[^a-zA-Z0-9 ]", " ");
    }
}

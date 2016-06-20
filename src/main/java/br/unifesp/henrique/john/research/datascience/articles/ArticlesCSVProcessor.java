package br.unifesp.henrique.john.research.datascience.articles;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticlesCSVProcessor {

    //CSV file header order
    private static final String [] FILE_HEADER_MAPPING = {"Cites","Authors","Title","Year","Source","Publisher","ArticleURL","CitesURL","GSRank","QueryDate","Type"};

    public List<Article> loadArticlesFromCSV(String filename) {

        try {
            FileReader reader = new FileReader("/home/john/IdeaProjects/JavaDataScience/src/test/resources/grupod.csv");
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
            CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }
}

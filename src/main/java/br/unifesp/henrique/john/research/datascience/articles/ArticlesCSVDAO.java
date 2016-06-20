package br.unifesp.henrique.john.research.datascience.articles;

import com.google.common.collect.Lists;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticlesCSVDAO {

    public static final String CITES = "Cites";
    public static final String AUTHORS = "Authors";
    public static final String TITLE = "Title";
    public static final String YEAR = "Year";
    public static final String SOURCE = "Source";
    public static final String PUBLISHER = "Publisher";
    public static final String ARTICLE_URL = "ArticleURL";
    public static final String CITES_URL = "CitesURL";
    public static final String GSRANK = "GSRank";
    public static final String QUERY_DATE = "QueryDate";
    public static final String TYPE = "Type";
    //CSV file header order
    private static final String [] FILE_HEADER_MAPPING = {CITES, AUTHORS, TITLE, YEAR, SOURCE, PUBLISHER, ARTICLE_URL, CITES_URL, GSRANK, QUERY_DATE, TYPE};

    public List<Article> loadArticlesFromCSV(String filename) {

        ArrayList<Article> articles = Lists.newArrayList();
        try {
            FileReader reader = new FileReader(filename);
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
            CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            for (int i = 1; i < csvRecords.size(); i++) {
                Article article = new Article();
                CSVRecord csvRecord = csvRecords.get(i);
                article.setCiteQuantity(csvRecord.get(CITES));
                article.setAuthors(csvRecord.get(AUTHORS));
                article.setTitle(csvRecord.get(TITLE));
                article.setYear(csvRecord.get(YEAR));
                article.setSource(csvRecord.get(SOURCE));
                article.setPublisher(csvRecord.get(PUBLISHER));
                article.setArticleURL(csvRecord.get(ARTICLE_URL));
                article.setCitesURL(csvRecord.get(CITES_URL));
                article.setGSRank(csvRecord.get(GSRANK));
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    public List<Article> loadArticlesJustWithSpecificColumns(String filename, ArticleSearchTemplateObject searchTemplateObject) {

        ArrayList<Article> articles = Lists.newArrayList();
        try {
            FileReader reader = new FileReader(filename);
            CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
            CSVParser csvFileParser = new CSVParser(reader, csvFileFormat);
            List<CSVRecord> csvRecords = csvFileParser.getRecords();
            for (int i = 1; i < csvRecords.size(); i++) {
                Article article = new Article();
                CSVRecord csvRecord = csvRecords.get(i);
                if(searchTemplateObject.isWithAuthors()){
                    article.setAuthors(csvRecord.get(AUTHORS));
                }
                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}

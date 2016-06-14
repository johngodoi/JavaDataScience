package br.unifesp.henrique.john.research.datascience.articles;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class Article {
    private String authors;
    private String title;
    private String publisher;
    private String source;
    private String year;
    private String articleURL;
    private int GSRank;
    private int citeQuantity;

    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getSource() {
        return source;
    }

    public String getYear() {
        return year;
    }

    public String getArticleURL() {
        return articleURL;
    }

    public int getGSRank() {
        return GSRank;
    }

    public int getCiteQuantity() {
        return citeQuantity;
    }
}

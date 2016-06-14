package br.unifesp.henrique.john.research.datascience.assertion.article;

import br.unifesp.henrique.john.research.datascience.articles.Article;
import br.unifesp.henrique.john.research.datascience.assertion.chart.PointsAssertion;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticlesAssertion {
    private final List<Article> articles;

    public ArticlesAssertion(List<Article> articles) {
        this.articles = articles;
    }

    public static ArticlesAssertion assertThose(List<Article> articles) {
        return new ArticlesAssertion(articles);
    }

    public ArticlesAssertion hasQtt(int qtt) {
        assertEquals("Quantidade de artigos",qtt,this.articles.size());
        return this;
    }

    public ArticleAssertion assertArticleOfIndex(int index) {
        return new ArticleAssertion(articles.get(index));
    }
}

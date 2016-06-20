package br.unifesp.henrique.john.research.datascience.articles;

import br.unifesp.henrique.john.research.datascience.assertion.article.ArticlesAssertion;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticlesCSVProcessorTest {
    @Test
    public void load5ArticlesFromCSV() throws Exception {
        ArticlesCSVProcessor processor = new ArticlesCSVProcessor();
        List<Article> articles = processor.loadArticlesFromCSV("teste.csv");
        assertEquals("Quantidade de artigos carregados", 5, articles.size());
        ArticlesAssertion.assertThose(articles).hasQtt(5).assertArticleOfIndex(0)
                .hasAuthors("John Maria Diane").hasTitle("Title for article").hasPublisher("publisher")
                .hasSource("journal").hasYear("2016").hasArticleURL("http://teste.com").hasGSRank(156)
                .hasCitesQtt(230);
    }
}

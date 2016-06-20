package br.unifesp.henrique.john.research.datascience.articles;

import br.unifesp.henrique.john.research.datascience.assertion.article.ArticlesAssertion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticlesCSVDAOTest {

    private ArticlesCSVDAO articlesCSVDAO;

    @Before
    public void setUp() throws Exception {
        articlesCSVDAO = new ArticlesCSVDAO();
    }

    @Test
    public void loadAllArticlesFromCSV() throws Exception {
        List<Article> articles = articlesCSVDAO.loadArticlesFromCSV("./src/test/resources/articles.csv");
        ArticlesAssertion.assertThose(articles).hasQtt(5).assertArticleOfIndex(0)
                .hasAuthors("G Booch").hasTitle("The unified modeling language user guide").hasPublisher("Pearson Education India")
                .hasSource("").hasYear("2005").hasArticleURL("").hasGSRank(742)
                .hasCitesQtt(11303);
    }

    @Test
    public void loadArticlesWithSpecificColumns() throws Exception {
        ArticleSearchTemplateObject searchTemplateObject = new ArticleSearchTemplateObject();
        searchTemplateObject =searchTemplateObject.withAuthors();
        List<Article> articles = articlesCSVDAO.loadArticlesJustWithSpecificColumns("./src/test/resources/articles.csv", searchTemplateObject);
        ArticlesAssertion.assertThose(articles).hasQtt(5).assertArticleOfIndex(0)
                .hasAuthors("G Booch").hasNotTitle().hasNotPublisher()
                .hasNotSource().hasNoYear().hasNotArticleURL().hasNotGSRank()
                .hasNotCitesQtt();
    }

    @Test
    public void loadArticlesWithAllColumns() throws Exception {
        ArticleSearchTemplateObject searchTemplateObject = new ArticleSearchTemplateObject();
        searchTemplateObject =searchTemplateObject.withAuthors().withTitle().withPublisher().withSource().withYear().withArticleURL().withGSRank().withCiteQuantity().withCiteURL();
        List<Article> articles = articlesCSVDAO.loadArticlesJustWithSpecificColumns("./src/test/resources/articles.csv", searchTemplateObject);
        ArticlesAssertion.assertThose(articles).hasQtt(5).assertArticleOfIndex(0)
                .hasAuthors("G Booch").hasNotTitle().hasNotPublisher()
                .hasNotSource().hasNoYear().hasNotArticleURL().hasNotGSRank()
                .hasNotCitesQtt();
    }
}

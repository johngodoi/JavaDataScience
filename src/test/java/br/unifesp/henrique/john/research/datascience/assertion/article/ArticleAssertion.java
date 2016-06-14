package br.unifesp.henrique.john.research.datascience.assertion.article;

import br.unifesp.henrique.john.research.datascience.articles.Article;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lab-Eletrofisio on 14/06/2016.
 */
public class ArticleAssertion {
    private final Article article;

    public ArticleAssertion(Article article) {
        this.article = article;
    }

    public ArticleAssertion hasAuthors(String authors) {
        assertEquals("Autores",authors,this.article.getAuthors());
        return this;
    }

    public ArticleAssertion hasTitle(String title) {
        assertEquals("Título",title, this.article.getTitle());
        return this;
    }

    public ArticleAssertion hasPublisher(String publisher) {
        assertEquals("Publicador", publisher, this.article.getPublisher());
        return this;
    }

    public ArticleAssertion hasSource(String source) {
        assertEquals("Fonte",source,this.article.getSource());
        return this;
    }

    public ArticleAssertion hasYear(String year) {
        assertEquals("Ano",year,this.article.getYear());
        return this;
    }

    public ArticleAssertion hasArticleURL(String url) {
        assertEquals("URL do artigo", url, this.article.getArticleURL());
        return this;
    }

    public ArticleAssertion hasGSRank(int position) {
        assertEquals("GS Rank", position, this.article.getGSRank());
        return this;
    }

    public ArticleAssertion hasCitesQtt(int qtt) {
        assertEquals("Quantidade de citações",qtt, this.article.getCiteQuantity());
        return this;
    }
}

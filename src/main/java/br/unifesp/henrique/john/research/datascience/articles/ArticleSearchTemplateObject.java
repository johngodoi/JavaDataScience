package br.unifesp.henrique.john.research.datascience.articles;

/**
 * Created by Lab-Eletrofisio on 20/06/2016.
 */
public class ArticleSearchTemplateObject {
    private boolean withAuthors;
    private boolean withTitle;
    private boolean withPublisher;
    private boolean withSource;

    public boolean isWithAuthors() {
        return withAuthors;
    }

    public ArticleSearchTemplateObject withAuthors() {
        this.withAuthors = true;
        return this;
    }

    public ArticleSearchTemplateObject withTitle() {
        this.withTitle = true;
        return this;
    }

    public ArticleSearchTemplateObject withPublisher() {
        this.withPublisher = true;
        return this;
    }

    public ArticleSearchTemplateObject withSource() {
        this.withSource = true;
        return this;
    }
}

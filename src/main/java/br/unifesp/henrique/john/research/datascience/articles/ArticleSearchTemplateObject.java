package br.unifesp.henrique.john.research.datascience.articles;

/**
 * Created by Lab-Eletrofisio on 20/06/2016.
 */
public class ArticleSearchTemplateObject {
    private boolean withAuthors;
    private boolean withTitle;
    private boolean withPublisher;
    private boolean withSource;
    private boolean withYear;
    private boolean withArticleURL;
    private boolean withGSRank;
    private boolean withCiteQuantity;
    private boolean withCiteURL;

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

    public ArticleSearchTemplateObject withYear() {
        this.withYear = true;
        return this;
    }


    public ArticleSearchTemplateObject withArticleURL() {
        this.withArticleURL = true;
        return this;
    }

    public ArticleSearchTemplateObject withGSRank() {
        this.withGSRank = true;
        return this;
    }

    public ArticleSearchTemplateObject withCiteQuantity() {
        this.withCiteQuantity = true;
        return this;
    }

    public ArticleSearchTemplateObject withCiteURL() {
        this.withCiteURL = true;
        return this;
    }
}

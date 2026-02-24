package function;

import data.Article;

import java.util.List;

public class CreateService {
    private List<Article> articles;

    public CreateService(List<Article> articles) {
        this.articles = articles;
    }

    public void addArticle(int id, String title, String content, String writer) {
        Article article = new Article(id, title, content, writer);
        articles.add(article);
    }
}

package function;

import java.util.List;
import data.Article;

// 게시글 삭제 기능 (손주현)
public class deleteArticle {
    Article article;
    public deleteArticle(Article article) {
        this.article = article;
    }

    // 게시글 id를 받으면 해당 게시글을 리스트에서 삭제함
    // 변경사항: 매개변수 List<Article> articles을 추가하여, 삭제할 게시글이 포함된 리스트를 전달받도록 수정
    public void delete(List<Article> articles, int id){
        if(article.getId() == id) {
            articles.remove(article);
        }
    }
}
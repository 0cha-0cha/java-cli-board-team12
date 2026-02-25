package function;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import data.Article;

// 게시글 삭제 기능
public class deleteArticle implements Page {
    private final Scanner sc;
    List<Article> articles;

    public deleteArticle(List<Article> articles, Scanner sc) {
        this.articles = articles;
        this.sc = sc;
    }

    public boolean delete(List<Article> articles, int id){
        Iterator<Article> iterator = articles.iterator();
        while (iterator.hasNext()) {
            Article article = iterator.next();
            if (article.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public void select() {
        System.out.println("삭제를 원하는 게시글 번호를 입력하십시오.");
        System.out.print("선택 > ");
        int id = sc.nextInt();
        show(id);
    }

    @Override
    public void show(int articleId) {
        loading(1.0, "삭제하는 중입니다...");
        if(delete(articles, articleId)){
            System.out.println("=================================");
            System.out.println("게시글 삭제가 완료되었습니다.");
            System.out.println("=================================");
        } else {
            System.out.println("=================================");
            System.out.println("게시글 삭제에 실패하였습니다.");
            System.out.println("=================================");
        }
    }
}
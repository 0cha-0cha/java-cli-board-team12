package function;

import java.util.List;
import java.util.Scanner;
import java.util.Iterator;
import data.Article;
import static function.PrintUtil.*;

// 게시글 삭제 기능
public class DeleteArticle implements Page {
    private final Scanner sc;
    List<Article> articles;

    public DeleteArticle(List<Article> articles, Scanner sc) {
        this.articles = articles;
        this.sc = sc;
    }

    // 게시글 삭제 메소드 (삭제 성공 여부 반환)
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
    // 삭제할 글 고르는 화면
    public void select() {
        slowPrintChar("삭제를 원하는 게시글 번호를 입력하세요.\n", 50);
        slowPrintChar("선택 > ", 50);
        int id = sc.nextInt();
        sc.nextLine();
        show(id);
    }

    @Override
    // 삭제 화면 
    // 삭제 성공 여부에 따라 예외처리 문구 출력
    public void show(int articleId) {
        loading(1.0, "게시글을 삭제하는 중입니다...");
        if(delete(articles, articleId)){
            slowPrintLine("=================================", 100);
            slowPrintChar("게시글 삭제가 완료되었습니다.\n",50);
            slowPrintLine("=================================", 100);
        } else {
            slowPrintLine("=================================", 100);
            slowPrintChar("게시글 삭제에 실패하였습니다.\n",50);
            slowPrintLine("=================================", 100);
        }
    }
}
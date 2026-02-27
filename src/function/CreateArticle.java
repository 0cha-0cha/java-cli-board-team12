package function;

import data.Article;
import static function.PrintUtil.*;
import java.util.List;
import java.util.Scanner;

public class CreateArticle implements Page {

    private final List<Article> articles;
    private final Scanner sc;

    public CreateArticle(List<Article> articles, Scanner sc) {
        this.articles = articles;
        this.sc = sc;
    }

    public void openCreatePage(int nextId) {
        show(nextId);
    }

    @Override
    public void select() {}

    @Override
    public void show(int nextId) {

        clear();
        slowPrintChar("새 게시글을 작성합니다.\n", 50);
        slowPrintLine("=================================", 100);
        String writer = readNonBlank("작성자");
        String title = readNonBlank("제목");
        String content = readNonBlank("내용");

        slowPrintLine("---------------------------------", 100);

        addArticle(nextId, title, content, writer);

        loading(1.0, "게시글을 등록하는 중입니다...");
        slowPrintLine("---------------------------------", 100);
        slowPrintChar("게시글 등록이 완료되었습니다.\n", 50);
        slowPrintLine("=================================", 100);
    }

    private void addArticle(int id, String title, String content, String writer) {
        articles.add(new Article(id, title, content, writer));
    }

    //입력 예외처리
    private String readNonBlank(String label) {
        while (true) {
            slowPrintChar(label + " > ", 50);
            String input = sc.nextLine();

            if (!input.trim().isEmpty()) {
                return input.trim();
            }

            slowPrintChar("빈 값은 입력할 수 없습니다.\n", 50);
        }
    }
}

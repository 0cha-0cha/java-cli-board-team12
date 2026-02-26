package function;

import data.Article;

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

        String writer = readNonBlank("작성자");
        String title = readNonBlank("제목");
        String content = readNonBlank("내용");

        System.out.println("---------------------------------");

        addArticle(nextId, title, content, writer);

        System.out.println("게시글 등록이 완료되었습니다.");
        System.out.println("=================================");
    }

    private void addArticle(int id, String title, String content, String writer) {
        articles.add(new Article(id, title, content, writer));
    }

    //입력 예외처리
    private String readNonBlank(String label) {
        while (true) {
            System.out.print(label + " > ");
            String input = sc.nextLine();

            if (!input.trim().isEmpty()) {
                return input.trim();
            }

            System.out.println("빈 값은 입력할 수 없습니다.");
        }
    }
}

package function;

import data.Article;

import java.util.List;
import java.util.Scanner;

import static function.PrintUtil.*;

public class UpdateArticle implements Page {
    private final Scanner sc;
    private final List<Article> articles;


    public UpdateArticle(List<Article> articles, Scanner sc) {
        this.articles = articles;
        this.sc = sc;
    }

    // 업데이트할 글 고르는 화면
    @Override
    public void select() {
        slowPrintChar("수정을 원하는 게시글 번호를 입력하세요.\n", 50);
        slowPrintChar("선택 > ", 50);
        int pageNum = sc.nextInt();
        sc.nextLine(); // 버퍼 비우는 용
        show(pageNum);
    }

    // 업데이트 화면
    @Override
    public void show(int pageNum) {
        slowPrintChar(pageNum + " 번 게시물 불러오는 중...\n", 50);
        slowPrintChar("........", 100);
        clear();
        slowPrintChar("게시글 정보를 불러왔습니다.\n", 50);

        // 페이지들 들어있는 ArrayList에서 순회하면서 불러올 페이지 찾기
        Article targetArticle = null;
        for (Article article : articles) {
            if (article.getId() == pageNum) {
                targetArticle = article;
                break;
            }
        }

        if (targetArticle == null) {
            slowPrintChar("해당 번호의 게시글이 존재하지 않습니다.\n", 50);
            return; // 수정 화면 종료
        }

        // 게시글을 찾았다면 기존 정보를 보여주기(제목, 글내용)
        slowPrintLine("=================================", 100);
        slowPrintLine(("번호 : " + targetArticle.getId()),300);
        slowPrintLine("제목 : " + targetArticle.getTitle(),300);
        slowPrintLine("작성자 : " + targetArticle.getWriter(), 300);
        slowPrintLine("작성일 : " + targetArticle.getCreatedAt(), 300);
        slowPrintLine("조회수 : " + targetArticle.getViewCount(), 300);
        slowPrintLine("내용 : " + targetArticle.getContent(), 300);
        slowPrintLine("=================================", 100);
        System.out.println();
        // 바꿀 제목, 내용을 입력받기
        slowPrintChar("바꿀 제목을 입력하세요(없다면 엔터) > ", 50);
        String newTitle = sc.nextLine();
        slowPrintChar("바꿀 내용을 입력하세요(없다면 엔터) > ", 50);
        String newContent = sc.nextLine();

        // Article객체에서 Setter 사용해서 데이터 수정하기
        if (!newTitle.isEmpty()) {
            targetArticle.setTitle(newTitle);
        }
        if (!newContent.isEmpty()) {
            targetArticle.setContent(newContent);
        }

        // 수정 내용 있을때만 로딩바 표시
        if (!newTitle.isEmpty() || !newContent.isEmpty()) {
            loading(1.0, "게시글을 수정하는 중입니다...");
        }
        slowPrintLine("---------------------------------", 100);
        slowPrintChar("게시글 수정이 완료되었습니다.\n", 50);
        slowPrintLine("=================================", 100);

    }
}

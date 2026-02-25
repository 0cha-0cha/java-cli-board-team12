package function;

import java.util.Scanner;

import static function.PrintUtil.slowPrintChar;
import static function.PrintUtil.slowPrintLine;

public class UpdateArticle implements Page {
    private final Scanner sc;

    public UpdateArticle(Scanner sc) {
        this.sc = sc;
    }

    // 업데이트할 글 고르는 화면
    @Override
    public void select() {
//        clear();
        slowPrintChar("수정을 원하는 게시글 번호를 입력하십시오.\n", 50);
        slowPrintChar("선택 > ", 50);
        int pageNum = sc.nextInt();
        sc.nextLine(); // 버퍼 비우는 용
        show(pageNum);
    }

    // 업데이트 화면
    @Override
    public void show(int pageNum) {
        slowPrintChar((pageNum + "번 게시물 불러오는 중...\n"), 50);
        slowPrintChar(".....................", 100);
        clear();
        slowPrintChar("게시글 정보를 불러왔습니다.\n", 50);
        System.out.println();

        // 페이지들 들어있는 ArrayList에서 순회하면서 불러올 페이지 찾기

        // 게시글을 찾았다면 기존 정보를 보여주기(제목, 글내용)
        slowPrintLine("=================================", 100);
        slowPrintLine(("번호 :  " + pageNum),400);
        slowPrintLine("제목 :  안녕하세요",400);
        slowPrintLine("내용", 400);
        slowPrintLine("---------------------------------", 100);
        slowPrintLine("한 줄 씩 출 력 하 기 1", 400);
        slowPrintLine("한 줄 씩 출 력 하 기 2", 400);
        slowPrintLine("한 줄 씩 출 력 하 기 3", 400);
        slowPrintLine("한 줄 씩 출 력 하 기 4", 400);
        slowPrintLine("---------------------------------", 100);
        System.out.println();
        // 바꿀 제목, 내용을 입력받기
        slowPrintChar("바꿀 제목을 입력하세요 > ", 50);
        String newTitle = sc.nextLine();
        System.out.println(newTitle);

        slowPrintChar("바꿀 내용 입력하세요 > ", 50);
        String newContent = sc.nextLine();
        System.out.println(newContent);

        // Article객체에서 Setter 사용해서 데이터 수정하기


    }
}

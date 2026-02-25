package function;

import java.util.Scanner;

public class UpdateArticle implements Page {
    private final Scanner sc;
    public UpdateArticle(Scanner sc){
        this.sc = sc;
    }

    // 업데이트할 글 고르는 화면
    @Override
    public void select() {
//        clear();
        System.out.println("수정을 원하는 게시글 번호를 입력하십시오.");
        System.out.print("선택 > ");
        int pageNum = sc.nextInt();
        show(pageNum);
    }

    // 업데이트 화면
    @Override
    public void show(int pageNum) {
        loading(1.0,"불러오는 중...");
        clear();
        System.out.println("=================================");
        System.out.println("번호 :  " + pageNum);
        System.out.println("제목 :  " );
        System.out.println("바꿀 제목 입력 :  ");
        String newTitle = sc.nextLine();


    }
}

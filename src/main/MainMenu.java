package main;

import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;

    public MainMenu(Scanner sc) {
        this.sc = sc;
    }

    public void show() {
        ProgressBar.displayProgressBar(3.0, "서버에 접속 중입니다...");
        try {
            Thread.sleep(500);
            System.out.println("\n접속 완료!");
            Thread.sleep(800);
            System.out.println("메인 화면으로 이동합니다.");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("오류 발생");
        }
        ClearScreen.clearScreen();

        while (true) {
            System.out.println("=================================");
            System.out.println("\t Java CLI Board");
            System.out.println("=================================");
            System.out.println("1. 게시글 등록");
            System.out.println("2. 전체 게시글 조회");
            System.out.println("3. 게시글 상세 조회");
            System.out.println("4. 게시글 수정");
            System.out.println("5. 게시글 삭제");
            System.out.println("0. 종료");
            System.out.println("---------------------------------");
            System.out.print("선택> ");
            int input = sc.nextInt();
            System.out.println();
            switch (input) {
                case 1: //게시글 등록
                    System.out.print("작성자 > ");
                    String writer = sc.nextLine();
                    System.out.print("제목 > ");
                    String title = sc.nextLine();
                    System.out.print("내용 > ");
                    String content = sc.nextLine();
                    System.out.println("---------------------------------");
                    //게시글 등록 기능 삽입
                    System.out.println("게시글 등록이 완료되었습니다.");
                    System.out.println("=================================");
                    break;
                case 2: //전체 게시글 조회
                    System.out.println("---------------------------------");
                    System.out.println("번호 | 제목\t | 작성자 | 작성일 | 조회수 ");
                    System.out.println("---------------------------------");
                    //게시글 조회 기능 삽입
                    // 1    | 안녕하세요          | 홍길동     | 2024-01-01    | 0
                    System.out.println("---------------------------------");
                    break;
                case 3: //게시글 상세 조회
                    System.out.println("조회를 원하는 게시글 번호를 입력하십시오.");
                    System.out.print("선택 > ");
                    int id = sc.nextInt();
                    System.out.println("=================================");
                    System.out.print("번호\t: ");
                    // 게시글 조회 기능 삽입
                    System.out.print("제목\t: ");
                    System.out.print("작성자\t: ");
                    System.out.print("작성일\t: ");
                    System.out.print("조회수\t: ");
                    System.out.println();
                    System.out.println("---------------------------------");
                    //게시글 조회 기능 삽입
                    System.out.println("=================================");
                    break;
                case 4: //게시글 수정
                    System.out.println("수정을 원하는 게시글 번호를 입력하십시오.");
                    System.out.print("선택 > ");
                    id = sc.nextInt();
                    System.out.println("=================================");
                    System.out.println("번호\t: "+id);
                    System.out.print("제목\t: ");
                    title = sc.nextLine();
                    //게시글 수정 기능 삽입
                    System.out.println("---------------------------------");
                    content = sc.nextLine();
                    //게시글 수정 기능 삽입
                    System.out.println("---------------------------------");
                    System.out.println("게시글 수정이 완료되었습니다.");
                    System.out.println("=================================");
                    break;
                case 5: //게시글 삭제
                    System.out.println("삭제를 원하는 게시글 번호를 입력하십시오.");
                    System.out.print("선택 > ");
                    id = sc.nextInt();
                    //게시글 삭제 기능 삽입
                    System.out.println("=================================");
                    System.out.println("게시글 삭제가 완료되었습니다.");
                    System.out.println("=================================");
                    break;
                case 0: //종료
                    System.out.println("서비스를 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴에 나와있는 번호만 입력해주십시오.");
            }
            System.out.println("확인하셨다면 아무키나 눌러주세요.");
            sc.nextLine();
            ClearScreen.clearScreen();
        }
    }
}

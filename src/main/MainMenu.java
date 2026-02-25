package main;

import data.Article;
import function.CreateService;
import function.UpdateArticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;

    private final List<Article> articles = new ArrayList<>();
    private int nextId = 1;

    private final CreateService createService;

    public MainMenu(Scanner sc) {
        this.sc = sc;
        this.createService = new CreateService(articles, sc);
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
            sc.nextLine();

            switch (input) {
                case 1: //게시글 등록
                    createService.openCreatePage(nextId);
                    nextId++;
                    break;
                case 2: //전체 게시글 조회
                    System.out.println("---------------------------------"); //등록 테스트용
                    if (articles.isEmpty()) {
                        System.out.println("(게시글이 없습니다)");
                    } else {
                        for (Article a : articles) {
                            System.out.println(a.getId() + " | " + a.getTitle() + " | " + a.getContent() + " | " + a.getWriter());
                        }
                    }
                    System.out.println("---------------------------------");
                    break;
                case 3: //게시글 상세 조회
                    break;
                case 4: //게시글 수정

                    break;
                case 5: //게시글 삭제

                    break;
                case 0: //종료
                    System.out.println("서비스를 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴에 나와있는 번호만 입력해주십시오.");
            }
            System.out.println("확인하셨다면 엔터를 눌러주세요.");
            sc.nextLine();
            ClearScreen.clearScreen();

        }

    }

}

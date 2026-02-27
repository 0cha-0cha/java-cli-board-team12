package main;

import data.Article;
import function.*;
import static function.PrintUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;
    private final List<Article> articles = new ArrayList<>();
    private int nextId = 1;

    private CreateArticle createArticle;
    private ReadArticle readArticle;
    private UpdateArticle updateArticle;
    private DeleteArticle deleteArticle;

    public MainMenu(Scanner sc) {
        this.sc = sc;
        this.createArticle = new CreateArticle(articles, sc);
        this.readArticle = new ReadArticle(articles, sc);
        this.updateArticle = new UpdateArticle(articles, sc);
        this.deleteArticle = new DeleteArticle(articles, sc);
        // 샘플 게시물 생성
        articles.add(new Article(nextId++, "첫 번째 게시물", "내용1", "작성자1"));
        articles.add(new Article(nextId++, "두 번째 게시물", "내용2", "작성자2"));
        articles.add(new Article(nextId++, "세 번째 게시물", "내용3", "작성자3"));
    }

    public void show() {
        createArticle = new CreateArticle(articles, sc);
        readArticle = new ReadArticle(articles, sc);
        updateArticle = new UpdateArticle(articles, sc);
        deleteArticle = new DeleteArticle(articles, sc);


        ProgressBar.displayProgressBar(2.0, "서버에 접속하는 중입니다...");
        try {
            Thread.sleep(500);
            System.out.println();
            slowPrintChar("\n접속 완료!\n", 50);
            Thread.sleep(500);
            slowPrintChar("메인 화면으로 이동합니다.", 50);
            Thread.sleep(1000);
        } catch (Exception e) {
            slowPrintChar("오류 발생", 50);
        }
        ClearScreen.clearScreen();

        while (true) {
            slowPrintLine("=================================", 100);
            slowPrintChar("\t Java CLI Board\n", 30);
            slowPrintLine("=================================", 100);
            slowPrintLine("1. 게시글 등록", 200);
            slowPrintLine("2. 전체 게시글 조회", 200);
            slowPrintLine("3. 게시글 상세 조회", 200);
            slowPrintLine("4. 게시글 수정", 200);
            slowPrintLine("5. 게시글 삭제", 200);
            slowPrintLine("0. 종료", 200);
            slowPrintLine("---------------------------------", 100);
            slowPrintChar("선택 > ", 50);

            String input = sc.nextLine();
            char inputChar = input.charAt(0);

            // 메뉴 번호 유효성 검사
            while(inputChar < '0' || inputChar > '5' || input.length() != 1) {
                slowPrintLine("** 메뉴에 나와있는 번호만 입력해주세요. **", 50);
                slowPrintChar("선택 > ", 50);
                input = sc.nextLine();
                if (input.length() == 1) {
                    inputChar = input.charAt(0);
                }
            }

            System.out.println();
            switch (inputChar) {
                case '1': //게시글 등록
                    createArticle.openCreatePage(nextId);
                    nextId++;
                    break;
                case '2': //전체 게시글 조회
                    readArticle.selectAll();
                    break;
                case '3': //게시글 상세 조회
                    readArticle.select();
                    break;
                case '4': //게시글 수정
                    updateArticle.select();
                    break;
                case '5': //게시글 삭제
                    deleteArticle.select();
                    break;
                case '0': //종료
                    slowPrintChar("서비스를 종료합니다.\n", 50);
                    slowPrintChar("다음에 다시 만나요!\n", 50);
                    return;
                default:
                    slowPrintChar("메뉴에 나와있는 번호만 입력해주세요.", 50);
            }
            slowPrintChar("계속 진행하시려면 엔터를 눌러주세요.", 50);
            sc.nextLine();
            ClearScreen.clearScreen();
        }
    }

}

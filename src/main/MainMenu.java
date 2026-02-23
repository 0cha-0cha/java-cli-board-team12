package main;

import java.util.Scanner;

public class MainMenu {
    private final Scanner sc;
    public MainMenu(Scanner sc) {
        this.sc = sc;
    }

    public void show() {
        ProgressBar.displayProgressBar(3.0, "서버에 접속 중입니다...");
        try{
            Thread.sleep(500);
            System.out.println("\n접속 완료!");
            Thread.sleep(800);
            System.out.println("메인 화면으로 이동합니다.");
            Thread.sleep(1000);
        } catch(Exception e){
            System.out.println("오류 발생");
        }
        ClearScreen.clearScreen();
        System.out.println("======= 자바 CLI 게시판 =======");
        System.out.print ("메뉴선택: ");
        int input = sc.nextInt();
        System.out.println("선택한 메뉴: " + input);
    }
}

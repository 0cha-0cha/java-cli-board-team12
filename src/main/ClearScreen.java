package main;

public class ClearScreen {
    public static void clearScreen() {
        // \033[H: 커서를 화면 맨 위 좌측으로 이동
        // \033[2J: 화면 전체를 지움
        System.out.print("\033[H\033[2J");
        System.out.flush(); // 버퍼에 있는 출력 내용을 즉시 터미널에 반영
    }
}

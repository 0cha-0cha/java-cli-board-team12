package main;

public class ProgressBar {

    private static final String ANSI_BG_WHITE = "\u001B[47m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void displayProgressBar(double duration, String message) {
        System.out.println(message);

        int totalSteps = 40; // 부드러운 스피너를 위해 단계 수 100 유지
        long interval = (long) ((duration * 1000) / totalSteps);
        char[] spinner = {'/', '-', '\\', '|'};

        for (int i = 0; i <= totalSteps; i++) {
            double progress = (double) i / totalSteps;
            int percent = (int) Math.round(progress * 100);
            int barLength = 20;
            int filledLength = (int) Math.round(barLength * progress);

            // 스피너 문자는 루프 인덱스에 따라 순환
            char spinnerChar = spinner[i % spinner.length];

            // 흰색 배경을 적용한 공백으로 진행률 채움
            String filledBar = ANSI_BG_WHITE + " ".repeat(filledLength) + ANSI_RESET;
            String emptyBar = " ".repeat(barLength - filledLength);

            // \r 을 이용해 현재 줄 덮어쓰기
            System.out.print("\r" + spinnerChar + " " + filledBar + emptyBar + " " + percent + "%");
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("\n진행이 중단되었습니다.");
                return;
            }
        }


    }
}

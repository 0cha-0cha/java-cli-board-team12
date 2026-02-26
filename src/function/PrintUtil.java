package function;

public class PrintUtil {
    private PrintUtil() {}

    // 한 줄씩 딜레이 주고 출력하기
    public static void slowPrintLine(String text, int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(text);
    }

    // 문자 한 개씩 딜레이 주고 출력하기
    public static void slowPrintChar(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

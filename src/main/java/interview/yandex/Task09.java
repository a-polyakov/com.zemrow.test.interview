package interview.yandex;

import java.util.Objects;

/**
 * Даны две строки.
 * <p>
 * Написать функцию, которая вернёт True, если из первой строки можно получить вторую, совершив не более 1 изменения (==
 * удаление / замена символа).
 */
public class Task09 {
    public static void main(String[] args) {
        String a = "sadfhklj";
        String b = "sadqfhklj";

        System.out.println("a " + a);
        System.out.println("b " + b);
        System.out.println("result " + almostEqual(a, b));
    }

    private static boolean almostEqual(String a, String b) {
        boolean result = Objects.equals(a, b);
        if (!result && a != null && b != null && Math.abs(a.length() - b.length()) <= 1) {
            if (a.length() == b.length()) {
                int changeCount = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        changeCount++;
                    }
                }
                if (changeCount <= 1) {
                    result = true;
                }
            }
            else if (a.length() > b.length()) {
                int i = 0;
                while (i < b.length() && a.charAt(i) == b.charAt(i)) {
                    i++;
                }
                while (i < a.length() - 1 && a.charAt(i + 1) == b.charAt(i)) {
                    i++;
                }
                result = i == b.length();
            }
            else {
                int i = 0;
                while (i < a.length() && a.charAt(i) == b.charAt(i)) {
                    i++;
                }
                while (i < b.length() - 1 && b.charAt(i + 1) == a.charAt(i)) {
                    i++;
                }
                result = i == a.length();
            }
        }
        return result;
    }
}

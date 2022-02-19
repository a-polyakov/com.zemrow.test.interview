package interview.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Дан список интов и число-цель. Нужно найти такие элементы, сумма которых будет давать число-цель.
 * <p>
 * elements = [1, -3, 4, 5]
 * <p>
 * target = 9
 * <p>
 * result = [4, 5]
 */
public class Task11 {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, -3, 4, 5);
        int target = 9;
        System.out.println("elements " + elements);
        System.out.println("target " + target);
        System.out.println("result " + findPart(elements, target));
    }

    private static List<Integer> findPart(List<Integer> elements, int target) {
        List<Integer> result = new ArrayList<>();
        int n = 1 << elements.size();
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < elements.size(); j++) {
                if (((1 << j) & i) != 0) {
                    sum += elements.get(j);
                }
            }
            if (sum == target) {
                for (int j = 0; j < elements.size(); j++) {
                    if (((1 << j) & i) != 0) {
                        result.add(elements.get(j));
                    }
                }
                break;
            }
        }
        return result;
    }
}

package interview.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Дан массив из нулей и единиц. Нужно определить, какой максимальный по длине подинтервал единиц можно получить, удалив
 * ровно один элемент массива.
 * <p>
 * [1, 1, 0]
 */
public class Task04 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1);
        System.out.println("in " + list);
        System.out.println("out " + maxPossibleLength(list));
    }

    private static int maxPossibleLength(List<Integer> list) {
        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                int count = 1;
                for (int j = i + 1; j < list.size() && list.get(j) == 1; j++) {
                    count++;
                    i++;
                }
                group.add(count);
            }
            else {
                int count = -1;
                for (int j = i + 1; j < list.size() && list.get(j) == 0; j++) {
                    count--;
                    i++;
                }
                group.add(count);
            }
        }
//        System.out.println("group "+group);
        int max = 0;
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i) > 0) {
                max = Math.max(max, group.get(i));
                if (i < group.size() - 2) {
                    if (group.get(i + 1) == -1) {
                        if (group.get(i + 2) > 0) {
                            max = Math.max(max, group.get(i) + group.get(i + 2));
                            i++;
                        }
                    }
                }
            }
        }
        return max;
    }
}

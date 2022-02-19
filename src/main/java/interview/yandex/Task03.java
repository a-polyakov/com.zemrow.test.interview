package interview.yandex;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Дан список интов, повторяющихся элементов в списке нет. Нужно преобразовать это множество в строку, сворачивая
 * соседние по числовому ряду числа в диапазоны. <br>
 * Примеры: <br>
 * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"<br>
 * [1,4,3,2] => "1-4"<br>
 * [1,4] => "1,4"
 */
public class Task03 {
    public static void main(String[] args) {
//        Set<Integer> set = new TreeSet(Arrays.asList(1, 4, 5, 2, 3, 9, 8, 11, 0));
//        Set<Integer> set = new TreeSet(Arrays.asList(1, 4, 3, 2));
        Set<Integer> set = new TreeSet(Arrays.asList(1, 4));

        System.out.println("in " + set);
        System.out.println("out " + group(set));
    }

    private static String group(Set<Integer> set) {
        final StringBuilder result = new StringBuilder();
        final Iterator<Integer> iterator = set.iterator();
        int current = iterator.next();
        int delta = 1;
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (current + delta == n) {
                delta++;
            }
            else {
                append(result, current, delta);
                result.append(',');
                current = n;
                delta = 1;
            }
        }
        append(result, current, delta);
        return result.toString();
    }

    private static void append(StringBuilder result, int current, int delta) {
        result.append(current);
        if (delta > 1) {
            result.append('-');
            result.append(current + delta - 1);
        }
    }

}

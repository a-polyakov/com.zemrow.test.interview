package interview.yandex;

import java.util.ArrayList;
import java.util.List;

/**
 * Слияние отрезков:
 * <p>
 * Вход: [1, 3] [100, 200] [2, 4] Выход: [1, 4] [100, 200]
 */
public class Task07 {
    public static class Segment {
        private int begin;
        private int end;

        public Segment(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        @Override public String toString() {
            final StringBuilder sb = new StringBuilder("(");
            sb.append(begin);
            sb.append(", ").append(end);
            sb.append(')');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        List<Segment> list = new ArrayList<>();
        list.add(new Segment(1, 3));
        list.add(new Segment(100, 200));
        list.add(new Segment(2, 4));

        System.out.println("in " + list);
        System.out.println("out " + compact(list));
    }

    private static List<Segment> compact(List<Segment> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Segment a = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Segment b = list.get(j);
                if (!(a.end - 1 < b.begin || a.begin > b.end - 1)) {
                    a.begin = Math.min(a.begin, b.begin);
                    a.end = Math.max(a.end, b.end);
                    list.remove(j--);
                }
            }
        }
        return list;
    }
}

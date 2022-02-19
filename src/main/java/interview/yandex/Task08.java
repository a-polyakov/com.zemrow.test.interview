package interview.yandex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Дан массив точек с целочисленными координатами (x, y). Определить, существует ли вертикальная прямая, делящая точки
 * на 2 симметричных относительно этой прямой множества.
 */
public class Task08 {
    public static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override public String toString() {
            final StringBuilder sb = new StringBuilder("(");
            sb.append(x);
            sb.append(", ").append(y);
            sb.append(')');
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1, 5));
        list.add(new Point(10, 200));
        list.add(new Point(19, 5));

        System.out.println("in " + list);
        System.out.println("out " + findVerticalSymmetry(list));
    }

    private static Integer findVerticalSymmetry(List<Point> list) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (Point point : list) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
        }
        int avgX = minX+(maxX - minX) / 2;
        list.sort(new Comparator<Point>() {
            @Override public int compare(Point o1, Point o2) {
                int result = o1.x - o2.x;
                if (result == 0) {
                    if (o1.x < avgX) {
                        result = o1.y - o2.y;
                    }
                    else {
                        result = o2.y - o1.y;
                    }
                }
                return result;
            }
        });
        boolean symmetry = true;
        for (int i = 0; symmetry && i < list.size() / 2; i++) {
            Point a = list.get(i);
            Point b = list.get(list.size() - 1 + i);
            symmetry = a.y == b.y;
        }
        return (symmetry) ? avgX : null;
    }
}

package interview.yandex;

import java.util.Arrays;
import java.util.List;

/**
 * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
 * <p>
 * elements = [1, -3, 4, 5]
 * <p>
 * target = 9
 * <p>
 * result = range(2, 4) # because elements[2] + elements[3] == target
 */
public class Task10 {
    public static void main(String[] args) {
        List<Integer> elements = Arrays.asList(1, -3, 4, 5);
        int target = 9;
        System.out.println("elements " + elements);
        System.out.println("target " + target);
        System.out.println("result " + findRange(elements, target));
    }

    private static Range findRange(List<Integer> elements, int target) {
        for (int begin = 0; begin < elements.size(); begin++) {
            int sum=elements.get(begin);
            for (int end = begin + 1; end <= elements.size(); end++) {
                if (target == sum) {
                    return new Range(begin, end);
                }
                if (end<elements.size()) {
                    sum += elements.get(end);
                }
            }
        }
        return null;
    }

    public static class Range {
        private int begin;
        private int end;

        public Range(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public int getBegin() {
            return begin;
        }

        public void setBegin(int begin) {
            this.begin = begin;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override public String toString() {
            final StringBuilder sb = new StringBuilder("range(");
            sb.append(begin);
            sb.append(", ").append(end);
            sb.append(')');
            return sb.toString();
        }
    }
}

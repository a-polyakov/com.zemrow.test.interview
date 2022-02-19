package interview.yandex;

import java.util.ArrayList;
import java.util.List;

/**
 * Даны даты заезда и отъезда каждого гостя. Для каждого гостя дата заезда строго раньше даты отъезда (то есть каждый
 * гость останавливается хотя бы на одну ночь). В пределах одного дня считается, что сначала старые гости выезжают, а
 * затем въезжают новые. Найти максимальное число постояльцев, которые одновременно проживали в гостинице (считаем, что
 * измерение количества постояльцев происходит в конце дня).
 * <p>
 * sample = [ (1, 2), (1, 3), (2, 4), (2, 3), ]
 */
public class Task05 {
    public static class Guest {
        private int begin;
        private int end;

        public Guest(int begin, int end) {
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
        List<Guest> list = new ArrayList<>();
        list.add(new Guest(1, 2));
        list.add(new Guest(1, 3));
        list.add(new Guest(2, 4));
        list.add(new Guest(2, 3));

        System.out.println("in " + list);
        System.out.println("out " + maxGuests(list));
    }

    private static int maxGuests(List<Guest> list) {
        int max = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            final Guest a = list.get(i);
            int intersection = 1;
            for (int j = i + 1; j < list.size(); j++) {
                final Guest b = list.get(j);
                if (!(a.end - 1 < b.begin || a.begin > b.end - 1)) {
                    intersection++;
                }
            }
            max = Math.max(max, intersection);
        }
        return max;
    }
}

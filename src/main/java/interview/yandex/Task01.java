package interview.yandex;

import java.util.ArrayList;
import java.util.List;

/**
 * Даны два массива: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
 * Надо вернуть [1, 2, 2, 3] (порядок неважен)
 */
public class Task01 {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>();
        a.add(1);a.add(2);a.add(3);a.add(2);a.add(0);

        List<Integer> b=new ArrayList<>();
        b.add(5);b.add(1);b.add(2);b.add(7);b.add(3);b.add(2);

        System.out.println("a "+a);
        System.out.println("b "+b);
        System.out.println("c "+ intersection(a, b));
    }

    private static List<Integer> intersection(List<Integer> a, List<Integer> b){
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<a.size();i++){
            for (int j=0;j<b.size(); j++){
                if (a.get(i).equals(b.get(j))){
                    result.add(a.get(i));
                    a.remove(i--);
                    b.remove(j);
                    break;
                }
            }
        }
        return result;
    }
}

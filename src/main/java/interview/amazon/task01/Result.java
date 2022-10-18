package interview.amazon.task01;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Result {

    public static void main(String[] args) {
        List<Integer> riceBags = Arrays.asList(new Integer[]{15748, 201811, 318847, 13210, 297232, 212524, 427183, 428856, 267115, 250071, 486535, 329842, 207752, 5349, 30253, 35974, 439843, 116477, 67998, 457859, 448342, 113678, 153035, 180891, 384202, 37906, 494481, 117701, 150825, 190556, 177762, 360751, 368876, 384462, 74251, 84325, 359440, 164217, 339607, 5500, 196212, 409073, 266934, 181317, 474544, 486089, 320144, 184494, 146786, 346676, 359617, 35237});

        System.out.println(Result.maxSetSize(riceBags));
    }

    /*
     * Complete the 'maxSetSize' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY riceBags as parameter.
     */
    public static int maxSetSize(List<Integer> riceBags) {
        if (riceBags == null || riceBags.size() < 2 || riceBags.size() > 200000) {
            return -1;
        }
        for (Integer current : riceBags) {
            if (current < 2 || current > 1000000) {
                // throw new IllegalArgumentException("2 <= n <= 1_000_000");
                return -1;
            }
        }
        //System.out.println("Input:"+riceBags);

        List<Integer> copyList = new LinkedList<>(riceBags);
        copyList.sort(Integer::compareTo);
        int result = -1;
        while (!copyList.isEmpty()) {
            int length = 1;
            int current = copyList.remove(0);
            while (!copyList.isEmpty()) {
                int next = current * current;
                if (next > 1000000) {
                    break;
                }
                int nextIndex = Collections.binarySearch(copyList, next);
                if (nextIndex >= 0) {
                    length++;
                    copyList.remove(nextIndex);
                } else if (-nextIndex > copyList.size()) {
                    break;
                }
                current = next;
            }
            if (length >= 2 && length > result) {
                result = length;
            }
        }
        return result;
    }

}

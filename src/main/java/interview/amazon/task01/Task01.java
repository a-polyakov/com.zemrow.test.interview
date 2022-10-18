package interview.amazon.task01;

import java.io.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * You are shopping on Amazon.com for some bags of rice. Each listing
 * displays the number of grains of rice that the bag contains. You want
 * to buy a perfect set of rice bags from the entire search results list,
 * riceBags. A perfect set of rice bags, perfect, is defined as:
 * • The set contains at least two bags of rice.
 * • When the rice bags in the set perfect are sorted in increasing order by
 *   grain count, it satisfies the condition perfect[i]*perfect[i]=perfect[i+1] for all 1 <= i< n.
 *   Here n is the size of the set and perfect[i] is the number of rice grains in bag i.
 * Find the largest possible set perfect and return an integer, the size of
 * that set. If no such set is possible, then return -1. It is guaranteed
 * that all elements in riceBags are distinct.
 * Example
 * Let the bags of rice available on Amazon have grain counts [3, 9, 4, 2, 16].
 * The following are the perfect sets.
 * • Set perfect = [3, 9]. The size of this set is 2.
 * • Set perfect = [4, 2]. The size of this set is 2.
 * • Set perfect = [4, 16]. The size of this set is 2.
 * • Set perfect = [4, 2, 16]. The size of this set is 3.
 * The size of the largest set is 3. The image below illustrates the
 * correct ordering of the purchased rice bags by grains of rice.
 * 2 -> 4 -> 16
 * Function Description
 * Complete the function maxSetSize in the editor below.
 * maxSetSize has the following parameter:
 * int riceBags[n]: the list of bags of rice by rice grain count
 * Returns
 * int: the size of the largest set possible or -1 if there is none
 * Constraints
 * • 1 <= n <= 2*10^5
 * • 2 <= riceBags[i] <= 10^6
 * Sample Case 0
 * [625, 4,2, 5, 25]
 * Output
 * 3
 * Explanation
 * all of the possible perfect sets:
 * [625, 25]
 * [4, 2]
 * [5, 25]
 * [625, 5, 25]
 */
public class Task01 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int riceBagsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> riceBags = IntStream.range(0, riceBagsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.maxSetSize(riceBags);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}




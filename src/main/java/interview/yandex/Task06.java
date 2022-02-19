package interview.yandex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sample Input ["eat", "tea", "tan", "ate", "nat", "bat"] Sample Output [ ["ate", "eat", "tea"], ["nat", "tan"],
 * ["bat"] ]
 * <p>
 * Т.е. сгруппировать слова по "общим буквам".
 */
public class Task06 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println("in " + list);
        System.out.println("out " + group(list));
    }

    private static Collection<List<String>> group(List<String> list) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : list) {
            String key = solveKey(s);
            List<String> value=map.get(key);
            if (value==null){
                value=new ArrayList<>();
                map.put(key, value);
            }
            value.add(s);
        }
        return map.values();
    }

    private static String solveKey(String s) {
        final char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

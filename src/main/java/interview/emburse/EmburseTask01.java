package interview.emburse;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class EmburseTask01 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s != null && !s.isEmpty()) {
            int end = 0;
            Map<Character, Integer> last = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                Integer j = last.get(c);
                if (j != null && j >= end) {
                    end = j + 1;
                }
                last.put(c, i);
                max = Math.max(max, i - end + 1);
            }
        }
        return max;
    }
}

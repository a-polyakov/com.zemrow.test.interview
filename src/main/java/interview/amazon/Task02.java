package interview.amazon;

/**
 * Amazon is developing a string processing library for some of its NLP-
 * related use cases. You are tasked with developing a service that takes
 * in a string consisting of lower case English letters and returns an
 * integer.
 * More formally, given a string, we define the frequency deviation of a
 * substring as the difference between the maximum and the minimum
 * frequencies of the characters in the substring. A substring of a string
 * is formed by any contiguous segment of the string. For example,
 * given "bbacccc", the character appearing most frequently is 'c' with 4
 * occurrences. The character that appears the fewest times is 'a' with 1
 * occurrence. The frequency deviation of the entire string is 4 -1 = 3.
 * Given a string, s, representing the input string, find the maximum
 * possible frequency deviation of any substring of the string.
 * Note: A substring of a string is formed by any contiguous segment of
 * the string.
 * Example
 * s is "aabb"
 * All distinct substrings are considered below.
 * • The segment "a" has a frequency deviation of 0. "a" occurs most and
 *   least frequently. Both values are 1, and 1 - 1 = 0.
 * • The segment "b" has a frequency deviation of 0.
 * • The segment "ab" has a frequency deviation of 0.
 * • The segment "aabb" has a frequency deviation of 0.
 * • The segment "aab" has a frequency deviation of 1.
 * • The segment "abb" has a frequency deviation of 1.
 * The maximum possible range is 1.
 * Function Description
 * Complete the function getMaxFreqDeviation in the editor below.
 * getMaxFreqDeviation has the following parameter(s):
 * string s: the learning model's output
 * Returns
 * int: the maximum range of any segment
 * Constraints
 * • 1 <= |s| <= 10^4, where |x| represents the length of some string x
 * • s consists of lowercase English letters only.
 * Input Format For Custom Testing
 * A single line of input contains the string s.
 *
 * Sample Case 0
 * Input
 * "bbacccabab"
 * Output
 * 2
 * Explanation
 * The substring "accc" and "ccca" have a range of freq(c) - freq(a) = 3 - 1 = 2.
 * No substring has a range greater than 2.
 *
 * Sample Case 1
 * Input
 * "aaaaa"
 * Output
 * 0
 *
 * Explanation
 * Since all characters are the same, max(freq) == min(freq) in all
 * substrings.
 */
public class Task02 {
    public static void main(String[] args) {
//        System.out.println(getMaxFreqDeviation("a"));
//        System.out.println(getMaxFreqDeviation("b"));
//        System.out.println(getMaxFreqDeviation("ab"));
//        System.out.println(getMaxFreqDeviation("aabb"));
//        System.out.println(getMaxFreqDeviation("aab"));
//        System.out.println(getMaxFreqDeviation("abb"));
//        System.out.println(getMaxFreqDeviation("bbacccabab"));
        System.out.println(getMaxFreqDeviation("abdbcdacbcadbbc"));
    }

    public static int getMaxFreqDeviation(String s) {
        System.out.println("S:"+s);
        char[] chars = s.toCharArray();
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int i=0;i<chars.length;){
            char c=chars[i];
            int len=1;
            int j=i+1;
            while (j<chars.length && chars[j]==c){
                j++;
                len++;
            }
            i=j;
            if (len<min){
                min=len;
            }
            if (len>max){
                max=len;
            }
        }
        return max-min;
    }
}

package interview.emburse;

/**
 * Write a program that reverses the order of words in a line separated by dots
 * Input: "i.like.this.program.very.much"
 * Output: "much.very.program.this.like.i"
 */
public class EmburseTask02 {
    public static void main(String[] args) {
        String s="i.like.this.program.very.much";
        String s2 = reverse(s);

        System.out.println(s);
        System.out.println(s2);
    }

    public static String reverse(String s){
        if (s != null && !s.isEmpty()) {
            String array[] = s.split("\\.");

            for (int f = 0, l = array.length - 1; f < l; f++, l--) {
                String tmp = array[f];
                array[f] = array[l];
                array[l] = tmp;
            }
            s = String.join(".", array);
        }
        return s;
    }
}

package interview.yandex;

/**
 * Дана строка (возможно, пустая), состоящая из букв A-Z: AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
 * Нужно написать функцию RLE, которая на выходе даст строку вида: A4B3C2XYZD4E3F3A6B28
 * И сгенерирует ошибку, если на вход пришла невалидная строка.
 * Пояснения: Если символ встречается 1 раз, он остается без изменений; Если символ повторяется более 1 раза, к нему добавляется количество повторений.
 */
public class Task02 {
    public static void main(String[] args) {
        String s="AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        System.out.println(s);
        System.out.println(rle(s));
    }

    private static String rle(String s) {
        final StringBuilder result=new StringBuilder();
        char current=s.charAt(0);
        int count=1;
        for (int i=1; i<s.length(); i++){
            char c=s.charAt(i);
            if (c==current){
                count++;
                if (i==s.length()-1){
                    append(result, current, count);
                }
            }else{
                append(result, current, count);
                current=c;
                count=1;
            }
        }
        return result.toString();
    }

    private static void append(StringBuilder result, char current, int count) {
        result.append(current);
        if (count > 1) {
            result.append(count);
        }
    }
}

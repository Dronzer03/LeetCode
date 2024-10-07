package Strings;

// LC - 443
// https://leetcode.com/problems/string-compression
public class StringCompression {

    public static int compress(char[] chars) {
        if (chars.length == 0 || chars.length == 1)
            return chars.length;
        int index = 0;
        int currCount = 1;
        for (int i=1; i < chars.length; i++) {
            if (chars[i-1] == chars[i]) {
                currCount++;
            } else {
                if (currCount == 1) {
                    chars[index++] = chars[i-1];
                } else {
                    chars[index++] = chars[i-1];
                    char[] countArr = ("" + currCount).toCharArray();
                    int j = 0;
                    while (j < countArr.length)
                        chars[index++] = countArr[j++];
                    currCount = 1;
                }
            }
        }
        if (currCount == 1) {
            chars[index++] = chars[chars.length - 1];
        } else {
            chars[index++] = chars[chars.length - 1];
            char[] countArr = ("" + currCount).toCharArray();
            int j = 0;
            while (j < countArr.length)
                chars[index++] = countArr[j++];
        }
        return index;
    }

    public int compressBetter(char[] chars) {
        int index = 0;
        int resultIndex = 0;

        while (index < chars.length) {
            char currentCharacter = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currentCharacter) {
                count++;
                index++;
            }
            chars[resultIndex++] = currentCharacter;
            if (count != 1) {
                for (char ch : Integer.toString(count).toCharArray())
                    chars[resultIndex++] = ch;
            }
        }

        return resultIndex;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress(arr));
    }
}

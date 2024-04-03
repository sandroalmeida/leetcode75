package info.sandroalmeida.educative.grokking_code_interview;

public class ReverseWords2 {
    public static String reverseWords(String sentence) {
        // 1: cleaning space excess
        sentence = sentence.replaceAll("\\s+", " ").trim();

        // 2: creating the chars array for doing all swaps in place
        char[] result = sentence.toCharArray();

        // 3: inverting the entire sentence
        reverseChars(result, 0, result.length - 1);

        // 4: iterating for re-reverting the words with 2 pointers
        int left = 0;
        for(int right = 0; right <= result.length; right++) {
            // when a space is found re-revert the word
            if(right == result.length || result[right] == ' ') {
                reverseChars(result, left, right - 1);
                left = right + 1;
            }
        }

        return new String(result);
    }

    private static void reverseChars(char[] chars, int start, int end) {
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String test = "  To be or not to be  ";
        System.out.println(reverseWords(test));
    }
}

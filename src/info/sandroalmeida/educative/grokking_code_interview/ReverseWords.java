package info.sandroalmeida.educative.grokking_code_interview;

public class ReverseWords {
    public static String reverseWords(String sentence) {
        // 0: cleaning space excess
        sentence = sentence.replaceAll("\\s+", " ").trim();

        // 1: reversing the entire sentence
        String reversedSentence = reverseString(sentence);

        // 2: iterate reversed sentence using 2 pointers
        // when space is found reverse the word
        // move the pointers to the next word
        int left = 0;
        int right = 0;
        while(right < reversedSentence.length()) {
            if(reversedSentence.charAt(right) == ' ' || right == reversedSentence.length() - 1) {
                String word;
                if(right == reversedSentence.length() - 1)
                    word = reversedSentence.substring(left);
                else
                    word = reversedSentence.substring(left, right);
                String reversedWord = reverseString(word);
                reversedSentence = reversedSentence.replace(word, reversedWord);
                left = right + 1;
            }
            right++;
        }

        return reversedSentence;
    }

    private static String reverseString(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        while(start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c: chars)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String test = "  To be or not to be  ";
        System.out.println(reverseWords(test));
    }
}

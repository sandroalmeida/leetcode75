package info.sandroalmeida.educative.grokking_code_interview._3_sliding_window;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences {
    public static Set<String> findRepeatedSequences(String s, int k) {

        Set<String> allSequences = new HashSet<>();
        Set<String> repeatedSequences = new HashSet<>();
        int left = 0;
        int right = k;
        while(right <= s.length()){
            String sequence = s.substring(left, right);
            if(allSequences.contains(sequence))
                repeatedSequences.add(sequence);
            allSequences.add(sequence);
            left++;
            right++;
        }

        return repeatedSequences;
    }

    public static void main(String[] args) {
        String s = "AGCTGAAAGCTTAGCTG";
        int k = 5;
        System.out.println(findRepeatedSequences(s, k));
    }
}

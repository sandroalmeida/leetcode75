package info.sandroalmeida;

import java.util.HashSet;
import java.util.Set;

public record PasonInterview() {

  public static void main(String[] args) {
    System.out.println(commonChar("abcde", "zx"));

    // one of the string null
    // one of the string 1 char
    // not matching chars
    // matching some
    // first string bigger
    // second string bigger
  }

  public static String commonChar(String str1, String str2) {
    if(str1 == null || str2 == null) return "";

    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    Set<Character> charSet = new HashSet<>();
    Set<Character> alreadyAdded = new HashSet<>();

    StringBuilder sb = new StringBuilder();

    // m=str1.length n=str2.length O(m)
    for(int i = 0; i < charArray1.length; i++) {
      charSet.add(charArray1[i]);
    }

    // o(n)
    for(int i = 0; i < charArray2.length; i++) {
      if(charSet.contains(charArray2[i]) && !alreadyAdded.contains(charArray2[i]))
        sb.append(charArray2[i]);
      alreadyAdded.add(charArray2[i]);
    }

    //O(m+n)

    return sb.toString();
  }

}

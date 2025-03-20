package info.sandroalmeida.leetcode150review;

import java.util.Stack;

public class SimplifyPath{

  public static void main(String[] args) {
    System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
  }

  public static String simplifyPath(String path) {
    String[] paths = path.split("/");
    Stack<String> stack = new Stack<>();

    for(String s: paths) {
      if(s.isEmpty() || s.equals(".")) {
        continue;
      } else if(s.equals("..")){
        if(!stack.empty())
          stack.pop();
      }else{
        stack.add(s);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(String s: stack) {
      sb.append("/");
      sb.append(s);
    }

    return !sb.isEmpty() ? sb.toString() : "/";
  }
}

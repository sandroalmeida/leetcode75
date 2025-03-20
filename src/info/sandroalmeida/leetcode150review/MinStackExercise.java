package info.sandroalmeida.leetcode150review;

import java.util.Stack;

public class MinStackExercise {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(5);
    System.out.println(minStack.getMin());
    minStack.push(10);
    minStack.push(2);
    System.out.println(minStack.getMin());
    minStack.pop();
    minStack.push(6);
    System.out.println(minStack.getMin());
  }
}

class MinStack {
  private Stack<int[]> stack;

  public MinStack() {
    this.stack = new Stack<>();
  }

  public void push(int val) {
    if(this.stack.isEmpty()) {
      stack.push(new int[]{val, val});
    } else{
      int currentMin = stack.peek()[1];
      stack.push(new int[]{val, Math.min(currentMin, val)});
    }
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
    return stack.peek()[1];
  }
}


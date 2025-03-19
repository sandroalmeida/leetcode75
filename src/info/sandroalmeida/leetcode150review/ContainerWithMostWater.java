package info.sandroalmeida.leetcode150review;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
  }

  public static int maxArea(int[] height) {
    int maxArea = 0;
    int start = 0, end = height.length - 1;

    while(start < end) {
      int currentArea = Math.min(height[start], height[end]) * (end - start);
      maxArea = Math.max(maxArea, currentArea);
      if(height[start] > height[end]) {
        end--;
      } else{
        start++;
      }
    }
    return maxArea;
  }
}

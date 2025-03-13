package info.sandroalmeida.leetcode150review;

public class TrappingRainWaterII {

  public static void main(String[] args) {
    int[] height = new int[]{4,2,0,3,2,5};
    System.out.println(trap(height));
  }

  public static int trap(int[] height) {
    int[] maxLeft = new int[height.length];
    int[] maxRight = new int[height.length];

    int currentMax = -1;
    for(int i = 0; i < height.length; i++) {
      if(i == 0){
        maxLeft[i] = 0;
      } else{
        currentMax = Math.max(height[i-1], currentMax);
        maxLeft[i] = currentMax;
      }
    }

    currentMax = -1;
    for(int i = height.length - 1; i >= 0; i--) {
      if(i == height.length - 1) {
        maxRight[i] = 0;
      } else{
        currentMax = Math.max(height[i+1], currentMax);
        maxRight[i] = currentMax;
      }
    }

    int result = 0;
    for(int i = 0; i < height.length; i++) {
      int value = Math.min(maxLeft[i], maxRight[i]) - height[i];
      if(value > 0) result += value;
    }
    return result;
  }

}

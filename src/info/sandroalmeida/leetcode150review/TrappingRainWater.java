package info.sandroalmeida.leetcode150review;

public class TrappingRainWater {

  public static void main(String[] args) {
    int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    System.out.println(trap(height));
  }

  public static int trap(int[] height) {
    // use two pointers starting from the idx 0
    // find the first top and then start to move the second pointer from the top
    // during the second pointer movement keep counting of the possible valley amount
    // when found a new top, higher than current, close counting and add to result
    // and move the first pointer for the new top
    int left = 0, right = 0;
    int total = 0;
    while(left < height.length) {
      while(!isIdxTop(height, left)){
        left++;
      }
      int subTotal = 0;
      right = left + 1;
      while(right < height.length && !isIdxTop(height, right)){
        subTotal += (height[left] - height[right]);
        right++;
      }
      if(right < height.length && height[right] < height[left]) {
        subTotal -= (height[left] - height[right]) * (right - left - 1);
      }
      if(isIdxTop(height, left) && isIdxTop(height, right))
        total += subTotal;
      left = right;
    }
    return total;
  }

  private static boolean isIdxTop(int[] height, int idx) {
    if(idx > height.length - 1) return false;
    if(idx == 0) {
      return height[idx] > height[idx + 1];
    } else if(idx == height.length - 1) {
      return height[idx] > height[idx - 1];
    } else {
      return height[idx] > height[idx + 1] && height[idx] > height[idx - 1];
    }
  }
}

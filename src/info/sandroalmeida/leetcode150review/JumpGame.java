package info.sandroalmeida.leetcode150review;

public class JumpGame {
  public static void main(String[] args) {
    System.out.println(canJump(new int[]{3}));
  }

  //Example 1:
  //
  //Input: nums = [2,3,1,1,4]
  //Output: true
  //Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
  //Example 2:
  //
  //Input: nums = [3,2,1,0,4]
  //Output: false
  //Explanation: You will always arrive at index 3 no matter what.
  //Its maximum jump length is 0, which makes it impossible to reach the last index.
  public static boolean canJump(int[] nums) {
    //start from the end and go backwards
    //everytime we move on step we know we have to have
    //a value equals or greater than the steps count
    //if true we can restart the count
    //if false we continue
    if (nums.length == 1) return nums[0] > 0;
    int count = 1;

    for(int i = nums.length - 1; i > 0; i--) {
        if(nums[i - 1] >= count) {
          if(i == 1) {
            return true;
          }
          count = 1;
        } else {
          count++;
        }
    }
    return false;
  }
}

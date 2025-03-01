package info.sandroalmeida.leetcode150review;

import java.util.ArrayList;
import java.util.List;

public class RandomizedSet {

  private List<Integer> nums;

  public RandomizedSet() {
    this.nums = new ArrayList<>();
  }

  public boolean insert(int val) {
    if(nums.contains(val)) {
      return false;
    } else{
      nums.add(val);
      return true;
    }
  }

  public boolean remove(int val) {
    if(nums.contains(val)) {
      nums.remove(nums.indexOf(val));
      return true;
    } else{
      return false;
    }
  }

  public int getRandom() {
    double random = Math.random() * 100;
    int step = 100 / this.nums.size();
    int idx = 0;
    while (random >= step) {
      idx++;
      step += step;
    }
    return this.nums.get(idx);
  }
}

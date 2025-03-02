package info.sandroalmeida.leetcode150review;

import java.util.*;

public class RandomizedSetII {

  Map<Integer, Integer> dict;
  List<Integer> list;
  Random rand = new Random();

  public RandomizedSetII() {
    dict = new HashMap();
    list = new ArrayList();
  }

  public boolean insert(int val) {
    if (dict.containsKey(val))
      return false;
    dict.put(val, list.size());
    list.add(list.size(), val);
    return true;
  }

  public boolean remove(int val) {
    if (!dict.containsKey(val))
      return false;
    // finding last element
    int lastElement = list.get(list.size() - 1);
    // finding idx of element to be removed
    int idx = dict.get(val);
    // replacing element to be removed by last element
    list.set(idx, lastElement);
    dict.put(lastElement, idx);
    // deleting last element
    list.remove(list.size() - 1);
    dict.remove(val);
    return true;

  }

  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}

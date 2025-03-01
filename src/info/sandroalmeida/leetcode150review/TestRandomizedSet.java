package info.sandroalmeida.leetcode150review;

public class TestRandomizedSet {

  public static void main(String[] args) {
    RandomizedSet randomizedSet = new RandomizedSet();
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.insert(2));
    System.out.println(randomizedSet.getRandom());
    System.out.println(randomizedSet.insert(1));
    System.out.println(randomizedSet.remove(2));
    System.out.println(randomizedSet.getRandom());
  }

}

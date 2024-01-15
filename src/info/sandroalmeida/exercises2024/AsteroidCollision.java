package info.sandroalmeida.exercises2024;

import java.util.Arrays;
import java.util.List;

/**
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size,
 * and the sign represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions.
 * If two asteroids meet, the smaller one will explode.
 * If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Example 1:
 * Input: asteroids = [5,10,-5]
 * Output: [5,10]
 * Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * Example 2:
 * Input: asteroids = [8,-8]
 * Output: []
 * Explanation: The 8 and -8 collide exploding each other.
 * Example 3:
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 * Constraints:
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0*/
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new java.util.ArrayList<>(Arrays.stream(asteroids).boxed().toList());
        for(int i = 0; i < list.size() - 1; i++) {
            int item1 = list.get(i);
            int item2 = list.get(i+1);
            if((item1 > 0 && item2 > 0) || (item1 < 0 && item2 < 0)) {
                continue;
            } else{
                if(Math.abs(item1) > Math.abs(item2)) {
                    list.remove(i + 1);
                } else if(Math.abs(item1) == Math.abs(item2)) {
                    list.remove(i + 1);
                    list.remove(i);
                } else {
                    list.remove(i);
                }
                i = -1;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] result = asteroidCollision(new int[]{10,2,-5});
        System.out.println(Arrays.toString(result));
    }
}

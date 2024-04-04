package info.sandroalmeida.educative.grokking_code_interview;

import java.util.AbstractMap;
import java.util.Map;

public class CircularArray {
    public static boolean circularArrayLoop(int[] nums) {

        for(int i = 0; i < nums.length; i++){
            boolean movingForward = nums[0] > 0;
            boolean directionChange = false;
            int p1 = i;
            int p2 = i;
            while(!directionChange) {
                // moving p1
                Map.Entry<Integer, Boolean> result = movingPointer(nums, p1, movingForward);
                p1 = result.getKey();
                // moving p2 first time
                result = movingPointer(nums, p2, movingForward);
                p2 = result.getKey();
                if(result.getValue()) break;
                // moving p2 second time
                result = movingPointer(nums, p2, movingForward);
                p2 = result.getKey();
                directionChange = result.getValue();
                if(!directionChange && p1 == p2)
                    return true;
            }
        }
        return false;
    }

    private static Map.Entry<Integer, Boolean> movingPointer(int[] nums, int index, boolean movingForward) {
        // Calculating new index candidate
        int newIndex = index + nums[index];
        // Checking for directions change
        boolean directionChange = (movingForward && newIndex < index) || (!movingForward && newIndex > index);

        if(newIndex > nums.length - 1) {
            newIndex = newIndex % nums.length;
        } else if(newIndex < 0) {
            if(Math.abs(newIndex) > nums.length - 1) {
                newIndex = (Math.abs(newIndex) % nums.length) * -1;
            }
            newIndex = nums.length + newIndex;
        }
        return new AbstractMap.SimpleEntry<>(newIndex, directionChange);
    }

    public static void main(String[] args) {
        int[] nums1 = {2,1,-1,-2};
        int[] nums2 = {1, 4, 3, 2, 1};
        int[] nums3 = {2, 5, -4, 3, -1, 4};
        System.out.println(circularArrayLoop(nums1));
        System.out.println(circularArrayLoop(nums2));
        System.out.println(circularArrayLoop(nums3));

    }
}

package com.company;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }

    public static void main(String args[]) {
        int[] sorted_array = new int[]{0,0,1,1,2,2,2,3,3,3,4,4};
        System.out.println(removeDuplicates(sorted_array));
        System.out.println(Arrays.toString(sorted_array));
    }
}

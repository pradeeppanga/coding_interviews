package com.company;

import java.util.Arrays;

public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate_extra_array(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
        System.out.println("extra array: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate(nums, 3);
        //rotate_extra_array(nums, 3);
    }
}

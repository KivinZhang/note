package com.example.demo.notes.test;

import java.util.HashMap;

/**
 * Created by zhangkai on 2018/9/19.
 */
public class TEST01 {

    /***
     * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
     ****/
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;






    }


    public static int[] twoSum1(int[] nums, int target) {//80ms

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; i < j; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{nums[i], nums[j]};
                }
            }
        }
        return null;
    }


    public int[] twoSum2(int[] nums, int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    //break; 70ms
                    return result; //28ms
                }
            }
        }
        return result;
    }

    //使用了单层for循环和 hashMap,减少时间复杂度
    public int[] twoSum3(int[] nums, int target){
        int result [] = new int[2];

        if(nums.length <1){
            return result;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                result[0] = i;
                result[1] =  map.get(target-nums[i]);
            }
        }
        return  result;
    }







}

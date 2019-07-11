package com.db520.algorithm.leetcode;

/**
 * 45. Jump Game II
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * @Description JumpGame2
 * @Author zhuyl
 * @Date 2019/7/9 11:25
 **/
public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        int[] nums3 = {1,1,2,2,0,1,1};
        System.out.println(new JumpGame2().jump(nums3));
    }

    public int jump(int[] nums) {
        int ret = 0;//当前跳数
        int last = 0;//上一跳可达最远距离
        int cur = 0;//当前一跳可达最远距
        for (int i = 0; i < nums.length; ++i) {
            //无法向前继跳直接返回
            //有可能无论怎么跳，都不能到达终点或者越过终点，比如[3,2,1,0,4]。
            if(i > cur){
                return -1;
            }
            //需要进行下次跳跃，则更新last和当执行的跳数ret
            if (i > last) {
                last = cur;
                ++ret;
            }
            //记录当前可达的最远点
            cur = Math.max(cur, i + nums[i]);
        }

        return ret;
    }

    public int jump2(int[] nums) {
        if(nums.length <= 1) {
            return 0;
        }

        return dfs(nums, 0, 0);
    }

    //timeout
    public int dfs(int[] nums, int index, int count) {
        if(index >= nums.length - 1) {
            return count;
        }
        if(nums[index] == 0) {
            return -1;
        } else {
            int min = -1;
            int res = -1;
            for (int i = 1; i <= nums[index]; i++) {
                res = dfs(nums, index + i, count + 1);
                if(min == -1) {
                    if(res != -1) {
                        min = res;
                    }
                } else {
                    if(res != -1) {
                        min = Math.min(res, min);
                    }
                }
            }
            return min;
        }
    }
}

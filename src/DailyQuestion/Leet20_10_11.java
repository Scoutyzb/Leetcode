package DailyQuestion;

import java.util.Arrays;

/**
 * @author:Scout
 * @data:2020/10/14
 * @description:给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @url:https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class Leet20_10_11 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        else
            if(backpack01(nums,sum/2)==sum/2)
                return true;
        return false;
    }
    public int backpack01(int[]goods,int capacity){
        int[][] dp = new int[goods.length+1][capacity+1];
        for(int j = 1; j<=capacity;j++){
            for(int i = 1;i<=goods.length;i++)
                if(j>=goods[i-1])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-goods[i-1]]+goods[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
        }
        return dp[goods.length][capacity];
    }


}

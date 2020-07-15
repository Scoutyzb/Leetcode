public class Sword_42 {
    public int origin_maxSubArray(int[] nums) {
        int[][] num_matrix = new int[nums.length][];
        int max=Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            num_matrix[i] = new int[nums.length-i];
            for(int j = 0; j <nums.length-i; j++){
                if(j==0)
                num_matrix[i][j] = nums[j+i];
                else
                num_matrix[i][j] = num_matrix[i][j-1]+nums[j+i];
                if(num_matrix[i][j]>max)
                    max = num_matrix[i][j];
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums){
        //本次dp的核心思想是,dp[i]数组代表以某位置结尾的最大值，即dp[i+1]可以直接利用这个结果,减少计算过程。
        //使用nums做dp数组，省空间。
        int max = 0;
        for(int i = 1 ;i<nums.length ; i++){
               if(nums[i-1]<=0)
                   nums[i]=nums[i];
               else if(nums[i-1]>0)
                   nums[i]=nums[i-1]+nums[i];
               if(max<nums[i])
                   max = nums[i];
        }
        return max;
    }

}

package DailyQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet_10_5 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i< nums.length&&nums[i]<0;i++){
            while(nums[i]==nums[i+1])
                i++;
            for(int j=i+1,k=nums.length-1;j<k;){

                while(nums[k]==nums[k-1])
                    k--;
                while(nums[j]==nums[j+1])
                    j++;
                if(nums[j]+nums[k]<-nums[i])
                    j++;
                else if(nums[j]+nums[k]>-nums[i])
                    k--;
                else
                    result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[k]}));
            }
        }
        return result;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<4)
            return  result;
        for(int i = 0;i<nums.length-3;i++){
            if(i>0&&nums[i-1]==nums[i])
                continue;
            if(nums[i]>target)
                break;
            for(int j = i+1;j< nums.length-2;j++){
                if(j>i+1&&nums[j-1]==nums[j])
                    continue;
                if(nums[i]+nums[j]>target)
                    break;
                    int r = nums.length-1;
                int l = j+1;
                while(l<r){
                    while (r < nums.length-1 && nums[r]==nums[r+1])
                        r--;
                    while (l > j+1 && nums[l-1]==nums[l])
                        l++;
                    if(l>=r)
                        break;
                    if(nums[i]+nums[j]+nums[l]+nums[r]==target)
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[l++],nums[r--]}));
                    else if(nums[i]+nums[j]+nums[l]+nums[r]>target)
                        r--;
                    else
                        l++;
                }
            }
        }
        return result;
    }
}

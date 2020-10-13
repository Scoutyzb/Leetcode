package DailyQuestion;

import java.util.HashMap;

import java.util.Map;


public class Leet20_10_3 {
    public int[] twoSum_doublcircle(int[] nums, int target) {
        int i=0;
        int j=0;
        for( i = 0; i < nums.length;i++)
            for( j = i+1 ; j < nums.length;j++)
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};
        return new int[]{i,j};
    }
    public int[] twoSum_hash(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(target-nums[i]))
                return (new int[]{i,map.get(target-nums[i])});
            else
                map.put(nums[i],i);
        }
        return null;
    }
}

package DailyQuestion;

public class Leet20_10_7 {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < nums.length&&i<p2; i++) {
            if (nums[i] == 0)
                swap(nums, i, p0++);
            else if(nums[i] == 2)
                swap(nums, i-- , p2--);
        }
    }
        private void swap(int[] nums,int i ,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }


}

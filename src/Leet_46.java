import java.util.ArrayList;
import java.util.List;

public class Leet_46 {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums){
        res = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        List<Integer> track = new ArrayList<Integer>();
        traceback( track,nums);
        return  res;
    }
    public void traceback(List<Integer> track,int[] nums){
        if(track.size()==nums.length){
            res.add(new ArrayList<Integer>(track));//回溯核心之一，由于java是对象传递，将目前的track回溯之后，会改变已经添加在res里的track，所以要新建一个list，。
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!track.contains(nums[i])){
                track.add(nums[i]);
                traceback(track,nums);
                track.remove(track.size()-1);
            }
        }
     return;
    }
}

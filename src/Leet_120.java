import java.util.List;
import java.util.ArrayList;


public class Leet_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //算法思想
        /*
        只存最小的n个值，即遍历到第几行存几个值。
        triangle.get(i)表示的是位于第i层的列
        triangle.get(i).get(j)表示的是第i层第j列。
        可以推出，上一层第j个值和下一层第j与j+1个值可以并列。
         */
        int minvector[] = new int[triangle.size()];
        minvector[0]=triangle.get(0).get(0);
        for(int i = 1;i<triangle.size();i++){
            for(int j = 0;j < triangle.get(i).size();j++){
                if(j == 0)
                    minvector[j] = triangle.get(i-1).get(j)+triangle.get(i).get(j);
                else if(j == triangle.get(i).size()-1)
                    minvector[j] = triangle.get(i-1).get(j-1)+triangle.get(i).get(j);
                else
                    minvector[j] = Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)) + triangle.get(i).get(j);
            }
            for(int j = 0 ; j<triangle.get(i).size();j++){
                triangle.get(i).set(j,minvector[j]);
            }
        }
        return getMin(minvector);
    }


    public int getMin(int min[]){
        int minnum = Integer.MAX_VALUE;
        for(int num:min){
            if(minnum > num)
                minnum = num;
        }
        return minnum;
    }
}

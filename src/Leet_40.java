import java.util.ArrayList;
import java.util.List;

public class Leet_40 {
    public class UnionFind{
        int father;
        int val;
        public UnionFind(int father, int val) {
            this.father = father;
            this.val = val;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<UnionFind> ufs = new ArrayList<UnionFind>();
        for(int i : candidates){
            ufs.add(new UnionFind(-1,i));
        }
        for(int i = 0;i<list.size();i++){

            UnionFind uf = ufs.get(i);
            if(uf.val<target) {
                for (int j = i + 1; j < list.size(); j++) {
                    if(ufs.get(j).val+uf.val<target){

                    }
                }
            }
        }
        return list;
    }
}

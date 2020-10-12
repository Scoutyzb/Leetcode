import java.util.*;

public class Leet_685 {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        /*

        //根节点，入度为0，出度>0   错误情况 无根，即没有入度为0出度>0的点，
        //子节点，入度为1  错误情况 多父，即入度>1
        //遍历？
        HashMap<Integer,Integer> out_degree = new HashMap<Integer,Integer>();
        Map<Integer,Integer> in_degree = new HashMap<Integer,Integer>();
        int wrongpoint=-1;
        int [] answer = new int[2];
        for(int i = 0; i<edges.length;i++){
            out_degree.put(edges[i][0],out_degree.getOrDefault(edges[i][0],0)+1);

            in_degree.put(edges[i][1],in_degree.getOrDefault(edges[i][1],0)+1);
            if(in_degree.get(edges[i][1])>1)
                wrongpoint=edges[i][1];
                System.out.println(wrongpoint);
        }
        if(wrongpoint!=-1){//存在入度为2
            for(int i = edges.length-1;i>=0;i--){
                if(edges[i][1]==wrongpoint){
                    if(in_degree.getOrDefault(edges[i][0],0)==0&&out_degree.getOrDefault(edges[i][1],0)==1)
                        continue;
                    else {
                        answer[0]=edges[i][0];
                        answer[1]=edges[i][1];
                        return answer;
                    }
                }
            }
        }
        else{//不存在入度为2的点
            for(int i = edges.length-1;i>=0;i--){
                if(in_degree.getOrDefault(edges[i][1],0)==1&&out_degree.getOrDefault(edges[i][1],0)!=0){
                    answer[0]=edges[i][0];
                    answer[1]=edges[i][1];
                    return answer;
                }
            }
        }
        return  answer;


         */
        Map<Integer,Integer> Unionfind = new HashMap<>();
        List<int[]> erupts = new ArrayList<>();
        List<int[]> circles = new ArrayList<>();
        for(int i = 0 ; i < edges.length ; i++){
            int[] edge = {edges[i][0],edges[i][1]};
            if(Unionfind.getOrDefault(edges[i][1],edges[i][1])!=edges[i][1]) //已经有了祖先
                erupts.add(edge);
            else if(getParent(Unionfind,edges[i][0])==getParent(Unionfind,edges[i][1])) //还没有祖先，查看有没有环路
                circles.add(edge);
            else
                Unionfind.put(edges[i][1],edges[i][0]);
        }
        if(erupts.isEmpty()){
            return circles.get(circles.size()- 1);
        }
        else{
            int[] edgee = erupts.get(0);
            if(circles.isEmpty()){
                return edgee;
            }
            else{
                int[] edge2 = {Unionfind.get(edgee[1]),edgee[1]};
                return edge2;
            }
        }
    }
    public int getParent(Map<Integer,Integer> map,int a){
        if(map.getOrDefault(a,a)==a)
            return a;
        else
            return getParent(map,map.get(a));
    }
}

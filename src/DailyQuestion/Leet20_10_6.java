package DailyQuestion;

import java.util.*;

public class Leet20_10_6 {
    private Map<Integer,List<Integer>> map;
    private int[] dp;
    private Map<Integer,int[]> nodeDp;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        map =  new HashMap<>();
        nodeDp = new HashMap<>();
        for(int i = 0;i<edges.length;i++)
            if(map.containsKey(edges[i][0]))
                map.get(edges[i][0]).add(edges[i][1]);
            else
                map.put(edges[i][0],new ArrayList<Integer>(Arrays.asList(new Integer[]{edges[i][1]})));
        dp = new int[N];
        for(int i = 0 ;i<N;i++)
            if (map.containsKey(i) && dp[i] == 0)
                dp[i] = getdp(i);
        nodeDp.put(0,dp);
        for(int i = 0;i<edges.length;i++) {
            int[] dp = nodeDp.get(edges[i][0]).clone();
            dp[edges[i][0]] -= dp[edges[i][1]] + map.get(edges[i][1]).size();
            dp[edges[i][1]] += dp[edges[i][0]] + map.get(edges[i][0]).size();
            nodeDp.put(edges[i][1],dp);
        }
        return nodeDp.get(1);
    }
    private int getdp(int i){
        if(map.containsKey(i)){
            List<Integer> list = map.get(i);
            for( int child : list)
                if(map.containsKey(child)&&dp[child]==0)
                    dp[i] += (1+getdp(child));
                else
                    dp[i] += (dp[child]+1);
            return dp[i];
        }
        else
            return 0;
    }
}

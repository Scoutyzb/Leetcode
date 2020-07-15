public class Leet_392 {
    public boolean isSubsequence(String s, String t) {
        char[] sa = s.toCharArray(); //短字符串
        char[] ta = t.toCharArray(); // 长字符串
        int j = 0;
        for(int i = 0;i < ta.length;i++){
            if(ta[i]==sa[j]){
                j++;
                if(j==sa.length){
                    return true;
                }
            }
        }
        return false;
    }
}

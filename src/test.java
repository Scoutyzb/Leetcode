import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> maxbase  = new ArrayList<>();
        int[] a = maxbase.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(a[0]);
   }
}

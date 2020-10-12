import java.util.EmptyStackException;
import java.util.Stack;

public class Leet_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }
            if(c==')'||c=='}'||c==']'){

            }
        }
        return true;
    }

}

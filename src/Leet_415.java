public class Leet_415 {

    public String addString(String num1,String num2){
        StringBuilder s1 = new StringBuilder();
        int addone = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(i>=0||j>=0||addone!=0){
            int n1 = (i<0)?0:num1.charAt(i--)-'0';
            int n2 = (j<0)?0:num2.charAt(j--)-'0';
            addone = n1+n2+addone;
            s1.append(addone%10);
            addone /= 10;
        }
        return  s1.reverse().toString();
    }
/*
    public String addStrings(String num1, String num2) {
        int addone = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        String answer = "";

        while(i>=0&&j>=0) {
            int n1 = (int) (num1.charAt(i)-'0');
            int n2 = (int) (num2.charAt(j)-'0');
            int outcome = n1 + n2 + addone;
            if (outcome >= 10) {
                addone = 1;
                outcome -= 10;
            }
            else
                addone = 0;
            answer = (char) (outcome + '0') + answer;
            i--;
            j--;
        }

        if(addone==1&&)
            String answer1 =

    return answer;
    }
    public String addOne(String num) {
        int i;
        String answer = "";
        for (i = num.length() - 1;i>=0;i--){
            if (num.charAt(i)!='9')
                break;
            else
                answer += '0';
        }
        if(i<0)
            return '1' + answer;
        System.out.println(num.substring(0,i));
        System.out.println((char)(num.charAt(i)+1));
        System.out.println(answer);
        return num.substring(0,i)+(char)(num.charAt(i)+1)+answer;
    } */
}

import java.util.Stack;

public class CalculatorStackDemo {
    public static int calculate(String s) {
        int num = 0;
        char sign = '+';
        int answer = 0;
        Stack<Integer> number = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9') || i == s.length() - 1) {
                if (sign == '+') {
                    number.push(num);
                } else if (sign == '-') {
                    number.push(-num);
                } else if (sign == '*') {
                    number.push(number.pop() * num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        answer = number.pop();
        while(!number.empty()) {
            answer += number.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = "5*2+10";
        int ans = calculate(str);
        System.out.println("ans: " + ans);
    }
}

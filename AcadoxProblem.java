
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 *
 * @author Gavin
 */
public class Solution {

    static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            System.out.println(calculate(input));
        }

    }

    public static String calculate(String input) {
        String[] splited = input.split("\\s+");
        Stack<Integer> stack = new Stack<Integer>();
        String answer;
        int numericalAnswer;
        try {
            for (String A : splited) {
                if (A.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                }
                else if (A.equals("-")) {
                    int temp = stack.pop();
                    stack.push(stack.pop() - temp);
                }
                else if (A.equals("&")) {
                    stack.push(stack.pop() & stack.pop());
                }
                //inclusive OR
                else if (A.equals("|")) {
                    stack.push(stack.pop() | stack.pop());
                }
                //exclusive OR
                else if (A.equals("X")) {
                    stack.push(stack.pop() ^ stack.pop());
                }
                
                else if(A.equals("~")){
                    stack.push(~stack.pop());
                }
                else {
                    stack.push(Integer.parseInt(A, 16));
                }
            }
            numericalAnswer = stack.pop();
            //underflow condition
            if (numericalAnswer < 0) {
                answer = "0000";
            }
            //overflow condition
            else if (numericalAnswer > 65535) {
                answer = "FFFF";
            }
            else {
                answer = Integer.toHexString(numericalAnswer).toUpperCase();
                if (answer.length() == 1) {
                    answer = "000" + answer;
                }
                if (answer.length() == 2) {
                    answer = "00" + answer;
                }
                if (answer.length() == 3) {
                    answer = "0" + answer;
                }
            }
        }
        catch (EmptyStackException | NumberFormatException e) {
            answer = "ERROR";
        }


        return answer;
    }
}

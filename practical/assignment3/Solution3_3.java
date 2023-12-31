/*
 * Mirza Hilmi Shodiq
 * 225150707111067
 */

package practical.assignment3;

import java.util.Scanner;
import java.util.Stack;

public class Solution3_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        char[] infix = (in.nextLine().replaceAll("\\s", "") + ")").toCharArray();
        in.close();
        stack.add('(');

        for(char chara : infix) {
            if (Character.isLetterOrDigit(chara)) {
                postfix.append(chara);
            } else if (chara == '(') {
                stack.add(chara);
            } else if (chara == ')') {
                while (true) {
                    char stackChara = stack.pop();
                    if (stackChara == '(') {
                        break;
                    }
                    postfix.append(stackChara);
                }
            } else {
                while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(chara)) {
                    postfix.append(stack.pop());
                }
                stack.add(chara);
            }
        }
        while (!stack.empty()) {
            postfix.append(stack.pop());
        }
        System.out.println(postfix.toString());
    }

    private static int getPrecedence(char chara) {
        switch (chara) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}

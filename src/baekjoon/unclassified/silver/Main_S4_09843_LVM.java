package baekjoon.unclassified.silver;

import java.io.*;
import java.util.*;

public class Main_S4_09843_LVM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();
        String[] commands = new String[N];
        for (int i = 0; i < N; i++)
            commands[i] = br.readLine().trim();

        int pointer = 0;
        int register = 0;
        while (pointer < N) {
            String[] parts = commands[pointer].split(" ");
            String command = parts[0];

            if (command.equals("PUSH")) {
                int value = Integer.parseInt(parts[1]);
                stack.push(value);
            } else if (command.equals("STORE")) {
                register = stack.pop();
            } else if (command.equals("LOAD")) {
                stack.push(register);
            } else if (command.equals("PLUS")) {
                stack.push(stack.pop() + stack.pop());
            } else if (command.equals("TIMES")) {
                stack.push(stack.pop() * stack.pop());
            } else if (command.equals("IFZERO")) {
                if (stack.pop() == 0) {
                    pointer = Integer.parseInt(parts[1]);
                    continue;
                }
            } else if (command.equals("DONE")) {
                System.out.println(stack.pop());
                return;
            }
            pointer++;
        }
    }
}

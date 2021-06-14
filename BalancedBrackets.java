import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0 ; i < str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch == '{' || ch == '[' || ch == '(')
            {
                stack.push(ch);
            }else if(ch=='}')
            {
                if(stack.size()==0 || stack.peek() !='{' ){
                System.out.println(false);
                return;
                }else{
                    stack.pop();
                }
            }else if(ch==')')
            {
                if(stack.size()==0 ||stack.peek() !='('  ){
                System.out.println(false);
                return;
                }else{
                    stack.pop();
                }
            }else if(ch==']')
            {
                if(stack.size()==0 || stack.peek() !='['){
                System.out.println(false);
                return;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty())
        System.out.println(true);
        else
        System.out.println(false);
    }

}

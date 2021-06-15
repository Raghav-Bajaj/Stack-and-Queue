import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
 Stack<String> post = new Stack<>();
    Stack<Integer> val = new Stack<>();
   Stack<String> infix = new Stack<>();
   for(int i = exp.length()-1; i >=0 ; i--)
   {
       char ch = exp.charAt(i);
       if(ch >= '0' && ch <= '9')
       {
         post.push(ch+"");
          infix.push(ch+"");
          val.push(ch-'0');
       }else if(ch == '+' || ch == '-' || ch=='*' || ch == '/')
       {
       
              String a = post.pop();
              String b = post.pop();
              String res = ""+ a + b +ch + "" ;
              post.push(res);
              
              String g = infix.pop();
              String h = infix.pop();
              String ans = "(" + g + ch + h+ ")" ;
              infix.push(ans);
              int x = val.pop();
              int y = val.pop();
             int jj =  Solver(x,y,ch);
             val.push(jj);
           }
       }
          System.out.println(val.pop());
            System.out.println(infix.pop());
            System.out.println(post.pop());
 }
public static int priority(char ch){
    if(ch == '-' || ch == '+')
        return 1 ;
    else if(ch == '/' || ch == '*')
        return 2 ;
    return 0 ;
}
public static int Solver(int n1 , int n2 , char ch){
    if(ch=='+')
    return n1 + n2 ;
    else if(ch == '-')
    return n1 - n2 ;
    else if(ch == '/')
    return n1/n2 ;
    else if(ch == '*')
    return n1*n2 ;
    return 0 ;
}
}

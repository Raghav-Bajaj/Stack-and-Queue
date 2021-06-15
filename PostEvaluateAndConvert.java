import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

   Stack<String> pre = new Stack<>();
    Stack<Integer> val = new Stack<>();
   Stack<String> infix = new Stack<>();
   for(int i = 0; i < exp.length() ; i++)
   {
       char ch = exp.charAt(i);
       if(ch >= '0' && ch <= '9')
       {
          pre.push(ch+"");
          infix.push(ch+"");
          val.push(ch-'0');
       }else if(ch == '+' || ch == '-' || ch=='*' || ch == '/')
       {
       
              String a = pre.pop();
              String b = pre.pop();
              String res = ""+ ch + b + a + "" ;
              pre.push(res);
              
              String g = infix.pop();
              String h = infix.pop();
              String ans = "(" + h + ch + g+ ")" ;
              infix.push(ans);
              int x = val.pop();
              int y = val.pop();
             int jj =  Solver(y,x,ch);
             val.push(jj);
           }
       }
          System.out.println(val.pop());
            System.out.println(infix.pop());
            System.out.println(pre.pop());
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

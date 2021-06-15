import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();

   Stack<Integer> num = new Stack<>();
    Stack<Character> op = new Stack<>();
    for(int i = 0 ; i < exp.length() ; i++)
    {
        char ch = exp.charAt(i);
        if(ch >= '0' && ch <= '9')
        {
            num.push(ch - '0');
        }else{
            if(ch == '('){
                op.push(ch);
            }else if(ch == ')')
            {
                while(op.size() >0 && op.peek() != '('){
                    char opt = op.pop();
                    int one = num.pop();
                    int two = num.pop();
                   int num3 = Solver(two , one , opt);
                   num.push(num3);
                }
                if(op.size() >0)
                    op.pop();
                
            }
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                if(op.size() > 0 && Priority(op.peek()) >= Priority(ch))
                {
                    char opt = op.pop();
                    int one = num.pop();
                    int two = num.pop();
                    int num3 =  Solver(two , one , opt);
                    num.push(num3);
                }
                    op.push(ch);
                
            }
        }
    
    }
    while(op.size() != 0 )
    {
                    char opt = op.pop();
                    int one = num.pop();
                    int two = num.pop();
                    int num3 = Solver(two , one , opt);
                    num.push(num3);
    }
    System.out.println(num.pop());
 }
 
 public static int Solver(int n1 , int n2 , char op)
 {
     int res = 0 ;
     if(op == '+')
     {
      res = n1 + n2 ;   
     }else if(op == '-'){
          res = n1 - n2 ;
     }else if(op == '*'){
          res = n1 * n2 ;
     }else if(op == '/'){
          res = n1 / n2 ;
     }
     return res ;
 }
  public static int Priority(char op)
 {
   
     if(op == '+')
     {
        return 1 ;   
     }else if(op == '-'){
        return 1 ;  
     }else if(op == '*'){
          return 2 ;  
     }else if(op == '/'){
        return 2 ;  
     }
     return 0 ;
 }
}

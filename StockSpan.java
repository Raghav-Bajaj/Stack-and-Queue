import java.io.*;
import java.util.*;

public class Main{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
  int n = arr.length ;
  int[] res = new int[n];
  Stack<Integer> stack = new Stack<>();
  stack.push(0);
  res[0] = 1;
  for(int i = 1 ; i < n ; i++)
  {
      while(stack.size() != 0 && arr[stack.peek()] < arr[i])
        stack.pop();
        if(stack.size() == 0)
            res[i] = i+1 ;
        else
            res[i] = i-stack.peek()  ;
            
        stack.push(i);
  }
  return res ;
 }

}

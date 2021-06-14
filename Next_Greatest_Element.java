import java.io.*;
import java.util.*;

public class Main
{
    
  public static void display(int[] a) {
    StringBuilder sb = new StringBuilder();

    for (int val : a) {
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
  }

  public static int[] solve(int[] arr) 
  {
      
    int n = arr.length ;
    int[] res = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    res[n - 1] = -1;
    stack.push(arr[n - 1]);
    for (int i = n - 2 ; i >= 0 ; i--)
    {
      while (stack.size() != 0 && stack.peek() < arr[i]) 
            stack.pop();
        if (stack.size() == 0)
          res[i] = -1 ;
        else
          res[i] = stack.peek();
        stack.push(arr[i]);
      }
       return res ;
    }
       
  }

import java.io.*;
import java.util.*;

public class Main{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    int[] nge = new int[n];
    nge[n-1] = n ;
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(n-1);
    for(int i = n-2 ; i>= 0 ; i--)
    {
        while(stack.size() > 0 && arr[i] > arr[stack.peek()])
            stack.pop();
        if(stack.size() == 0)
            nge[i] = n ;
        else
            nge[i] = stack.peek();
        stack.push(i);
    }
    int j = 0 ;
    for(int i = 0 ; i <= n - k ; i++)
    {
            if(j < i)
            {
                j = i ;
            }
            while(nge[j] < i+k)
            {
                j = nge[j];
            }
            System.out.println(arr[j]);
    }
 }
}

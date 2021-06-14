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

  int[] left = new int[n];
  Stack<Integer> stl = new Stack<>();
  left[0] = -1 ;
  stl.push(0);
     for(int i = 1; i < n; i++){
         while(stl.size() != 0 && arr[i] <= arr[stl.peek()])
            stl.pop();
        if(stl.size() == 0)
        {
            left[i] = -1 ;
        }else{
            left[i] = stl.peek();
        }
        stl.push(i);
     }
    int[] right = new int[n];
  Stack<Integer> str = new Stack<>();
    right[n-1] = n ;
  str.push(n-1);
     for(int i = n-2; i >= 0; i--){
         while(str.size() != 0 && arr[i] <= arr[str.peek()])
            str.pop();
        if(str.size() == 0)
        {
            right[i] = n ;
        }else{
            right[i] = str.peek();
        }
        str.push(i);
     }
  int max = 0;
     for(int i = 0; i < n; i++){
         int width = right[i] - left[i] - 1 ;
         int area = arr[i] * width ;
         if(area > max)
            max = area ;
     }
     System.out.println(max);
 }
}

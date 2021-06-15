import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
     Stack<Integer> st = new Stack<Integer>();
     for(int i = 0 ; i < arr.length ; i++)
     {
         st.push(i);
     }
     while(st.size() > 1)
     {
         int i = st.pop();
         int j = st.pop();
         if(arr[i][j] == 1)
            st.push(j);
        else
            st.push(i);
     }
     int p = st.pop();
     for(int i = 0 ; i < arr.length ; i++)
     {
         if(i != p && arr[i][p] != 1)
          {  System.out.println("none");
            return ;
     }else if(arr[p][i] != 0){
          System.out.println("none");
            return ;
     }
     }
          System.out.println(p);
           
    }


}

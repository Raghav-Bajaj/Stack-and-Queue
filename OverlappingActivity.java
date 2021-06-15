import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for(int i = 0 ; i < arr.length ; i++)
        {
            Pair pt = new Pair(arr[i][0],arr[i][1]);
            pairs[i] = pt ;
        }
        Arrays.sort(pairs);
        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);
        for(int i = 1 ; i < pairs.length ; i++)
        {
            Pair pr = st.peek();
            if(pr.end >= pairs[i].st )
            {
                pr.end = Math.max(pairs[i].end , pr.end);
                st.pop();
                st.push(pr);
            }else{
                st.push(pairs[i]);
            }
            
        }
        Stack<Pair> str = new Stack<>();
        while(!st.isEmpty())
        {
            str.push(st.pop());
        }
        while(!str.isEmpty()){
            Pair p = str.pop();
            System.out.println(p.st + " " + p.end);
        }
    }
    public static class Pair implements Comparable<Pair>
    {
        int st ;
        int end ;
        Pair(int st , int end)
        {
             this.st = st ;
            this.end = end ;
        }
        public int compareTo(Pair other)
        {
            if(this.st != other.st)
                return this.st - other.st ;
            return this.end - other.end ;
        }
        
    }

}

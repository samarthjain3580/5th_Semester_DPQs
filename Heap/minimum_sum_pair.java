package Heap;
import java.util.*;
public class minimum_sum_pair {

	public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr=new int[n];
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
            pq.add(arr[i]);
        }
        
        int sum=0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum = sum + (a + b);
            pq.add(a + b);
        }
        
        System.out.println(sum);
        sc.close(); // Close the scanner to avoid resource leak
    }
}
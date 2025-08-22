package Heap;

import java.util.*;

public class IPO {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input: number of projects n, number of selections k, initial capital w
        int n = sc.nextInt();
        int k = sc.nextInt();
        int w = sc.nextInt();
        int[] profits = new int[n];
        int[] capital = new int[n];
        // Input: n projects, each with capital and profit
        for (int i = 0; i < n; i++) {
            capital[i] = sc.nextInt(); // required capital
        }
        for (int i = 0; i < n; i++) {
            profits[i] = sc.nextInt(); // profit
        }
        IPO ipo = new IPO();
        int result = ipo.findMaximizedCapital(k, w, profits, capital);
        System.out.println(result);
        sc.close();
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];  // required capital
            projects[i][1] = profits[i];  // profit
        }

        Arrays.sort(projects, (a, b) -> a[0] - b[0]); // sort by capital needed
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>((a, b) -> b - a); // max-heap for profits

        int i = 0;
        while (k > 0) {
            while (i < n && projects[i][0] <= w) {
                maxProfit.add(projects[i][1]);
                i++;
            }

            if (maxProfit.isEmpty()) break; // no project can be done

            w += maxProfit.poll();
            k--;
        }

        return w;
    }
}

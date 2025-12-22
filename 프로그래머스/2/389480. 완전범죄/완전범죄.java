class Solution {
    public int solution(int[][] info, int n, int m) {
      
        int totalTraceA = 0;
        for (int[] item : info) {
            totalTraceA += item[0];
        }
        
        int capacity = m - 1; 
        int[] dp = new int[capacity + 1];
        for (int[] item : info) {
            int traceA = item[0]; 
            int traceB = item[1];
            for (int j = capacity; j >= traceB; j--) {
                dp[j] = Math.max(dp[j], dp[j - traceB] + traceA);
            }
        }
        
        int maxSavedA = 0;
        for (int val : dp) {
            maxSavedA = Math.max(maxSavedA, val);
        }

        int finalTraceA = totalTraceA - maxSavedA;
        if (finalTraceA < n) {
            return finalTraceA;
        } else {
            return -1;
        }
    }
}
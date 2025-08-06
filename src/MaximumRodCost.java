import java.util.*;

public class MaximumRodCost {

    private static int getMaxCost(int[] costArray){
        int n=costArray.length;
        int[] dp = new int[n+1]; // added one extra size to avoid 0 based check while checking for previous rod length further while populating dp.
        dp[0] = 0;

        //populating dp to get the cost if only cut 1 length rod at a time
        for(int i=1;i<=n;i++){
            dp[i] = costArray[0]*i;
        }

        //iterate for all the rod length,
        // Each iteration provides what will be the max cost if cutting rods is allowed only until cur length.
        for(int i=1;i<n;i++){
            int cost = costArray[i];
            int curLen = i+1;
            for(int j=curLen;j<=n;j++){
                //dp[j] inside max has max cost from previous cut rod length and
                // dp[j-curLen]+cost is choosing cur len and previous cut rod length with cost length reduced
                dp[j] = Math.max(dp[j], dp[j-curLen]+cost);
            }
        }
        return dp[n];
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide Test Cases");
        int t = sc.nextInt();
        while(t>0){
            t--;
            int rodLength = sc.nextInt();
            int[] costArray = new int[rodLength];
            for(int i=0;i<rodLength;i++){
                costArray[i] = sc.nextInt();
            }
            System.out.println("The maximum cost is: " + MaximumRodCost.getMaxCost(costArray));
        }
    }
}

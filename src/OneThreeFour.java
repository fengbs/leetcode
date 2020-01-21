/**
 * Created by lideqing@xiaomi.com on 19-11-25
 */
public class OneThreeFour {
    private int [] gas;
    private int [] cost;
    private int [] dp;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || cost == null) {
            return 0;
        }
        int sum = 0 ;
        int start = -1;
        int curDiff = 0;
        for ( int i = 0 ; i < gas.length ; ++i ) {
            int diff =  gas[i]-cost[i];
            sum += diff;
            curDiff += diff;
            if (curDiff < 0) {
                start = i+1;
                curDiff = 0;
            }
        }
        if (sum < 0) {
            return -1;
        } else {
            return start;
        }
    }

    public static void main (String []args) {
        OneThreeFour oneThreeFour = new OneThreeFour();
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};
        System.out.println(oneThreeFour.canCompleteCircuit(gas,cost));
    }
}

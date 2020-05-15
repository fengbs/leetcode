/**
 * Created by lideqing@xiaomi.com on 20-2-17
 */
public class OneThreeFour2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int index = 0;
        int start = 0;
        for ( int i = 0 ; i <gas.length ; ++i ) {
            sum += gas[i] - cost[i];
            start += gas[i] - cost[i];
            if (start < 0) {
                index = i+1;
                start = 0;
            }
        }
        if (sum < 0) {
            return -1;
        } else {
            return index;
        }
    }

    public static void main(String[] args) {
        OneThreeFour2 oneThreeFour2 = new OneThreeFour2();
        int []gas = {1,2,3,4,5};
        int []cost = {3,4,5,1,2};
        System.out.println(oneThreeFour2.canCompleteCircuit(gas,cost));
    }
}

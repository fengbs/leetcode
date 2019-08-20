import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-8-2
 */
public class FiveSeven {
	public int[][] insert(int[][] intervals,int[] newInterval) {
		boolean flag = true;
		int i = 0 ;
		for ( ; i < intervals.length ; ++i ) {
			if ( flag && newInterval[0] > intervals[i][1] ) {
				continue;
			} else {
				break;
			}
		}
		int startI = i;
		while ( i < intervals.length) {
			if ( intervals[i][0] <= newInterval[0] ) {
				newInterval[0] = intervals[i][0];
				newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
			} else if ( intervals[i][0] > newInterval[0] && newInterval[1] >= intervals[i][0] ) {
				newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
			} else {
				break;
			}
			++i;
		}
		int length = intervals.length - ( i - startI ) + 1;
		int res[][] = new int[length][2];
		for (int j = 0 ; j < startI ; ++j ) {
			res[j][0] = intervals[j][0];
			res[j][1] = intervals[j][1];
		}
		res[startI][0] = newInterval[0];
		res[startI][1] = newInterval[1];
		int resI = startI+1;
		for ( int j = i ; j < intervals.length ; ++j ) {
			res[resI][0] = intervals[j][0];
			res[resI][1] = intervals[j][1];
			++resI;
		}
		return res;
	}


	public static void main(String[] args) {
		FiveSeven fiveSeven = new FiveSeven();
		int intervals[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int interval[] = {4,8};
		int[][] res = fiveSeven.insert(intervals,interval);
		for ( int[] inter : res ) {
			System.out.println(inter[0] + " " + inter[1]);

		}
	}

}

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lideqing@xiaomi.com on 19-3-14
 */
public class OneThousandAndOne {

	public int[] gridIllumination( int N , int[][] lamps , int[][] queries ) {
		Map<Integer,Integer> xMap = new HashMap<>();
		Map<Integer,Integer> yMap = new HashMap<>();
		Map<Integer,Integer> s1Map = new HashMap<>();
		Map<Integer,Integer> s2Map = new HashMap<>();
		Set<Integer> lampSet = new HashSet<>();
		for ( int[] lamp: lamps ) {
			xMap.put(lamp[0],xMap.get(lamp[0])==null?1:xMap.get(lamp[0])+1);
			yMap.put(lamp[1],yMap.get(lamp[1])==null?1:yMap.get(lamp[1])+1);
			int slope = lamp[0] - lamp[1];
			s1Map.put(slope,s1Map.get(slope)==null?1:s1Map.get(slope)+1);
			slope = lamp[0] + lamp[1];
			s2Map.put(slope, s2Map.get(slope) == null ? 1 : s2Map.get(slope) + 1);
			lampSet.add(lamp[0] + lamp[1]*100000);
		}
		int []res = new int[queries.length];
		for ( int i = 0 ; i < queries.length ; ++i ) {
			if ( xMap.get(queries[i][0])!=null && xMap.get(queries[i][0]) > 0
				|| yMap.get(queries[i][1])!=null && yMap.get(queries[i][1]) > 0
				|| s1Map.get(queries[i][0] - queries[i][1]) != null && s1Map.get(queries[i][0] - queries[i][1])>0
				|| s2Map.get(queries[i][1] + queries[i][0]) != null && s2Map.get(queries[i][1] + queries[i][0])>0) {
				res[i] = 1;
				//shut down
				updateMap(xMap,yMap,s1Map,s2Map,lampSet,queries[i],N);
			} else {
				res[i] = 0;
			}


		}
		return res;
	}


	private void updateMap(Map<Integer,Integer> xMap,Map<Integer,Integer> yMap,Map<Integer,Integer> s1Map,Map<Integer,Integer> s2Map,Set<Integer> lampSet,int[]Point,int N) {
		for ( int i = Point[0]==0?0:Point[0]-1; i < (Point[0]+2 > N?N:Point[0]+2) ; ++i ) {
			for ( int j = Point[1]==0?0:Point[1]-1; j < (Point[1]+2 > N?N:Point[1]+2) ; ++j ) {
				if (lampSet.contains(i + j *100000)) {
					if (xMap.get(i) != null) {
						xMap.put(i, xMap.get(i) - 1);
					}
					if (yMap.get(j) != null) {
						yMap.put(j, yMap.get(j) - 1);
					}
					int slope = i - j;
					if (s1Map.get(slope) != null) {
						s1Map.put(slope, s1Map.get(slope) - 1);
					}
					slope = i+j;
					if (s2Map.get(slope) != null) {
						s2Map.put(slope, s2Map.get(slope) - 1);
					}
					lampSet.remove(i + j*100000);
				}
			}
		}
	}

	public static void main ( String []args ) {
		OneThousandAndOne oneThousandAndOne = new OneThousandAndOne();
		int N = 5;
		int lamps[][] = {{0,0},{1,0}};
		int queries[][] = {{1,1},{1,1}};
		int[] res = oneThousandAndOne.gridIllumination(N,lamps,queries);
		for ( Integer item : res ) {
			System.out.println(item);
		}
	}

}

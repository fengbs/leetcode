import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lideqing@xiaomi.com on 19-5-16
 */
public class OneFourNine {
	class Slope {
		int x;
		int y;
		int yNode;
		public Slope(int x,int y , int yNode) {
			this.x = x;
			this.y = y;
			this.yNode = yNode;
		}
	}
	public int maxPoints( Point[] points ) {
		if ( points==null || points.length == 0 ) {
			return 0;
		}
		if ( points.length <= 2 ) {
			return points.length;
		}
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if ( o1.x != o2.x ) {
					return o1.x - o2.x;
				} else {
					return o1.y - o2.y;
				}
			}
		});
		Map<String,Integer> map = new HashMap<>();
		for ( int i = 0 ; i < points.length ; ++i ) {
			for ( int j = i+1 ; j < points.length;++j ) {
				int xCha = points[i].x - points[j].x;
				int yCha = points[i].y - points[j].y;
				if ( xCha != 0 && yCha != 0 ) {
					int gcd = gcd(xCha,yCha);
					xCha = xCha/gcd;
					yCha = yCha/gcd;
				}
				String key = xCha +"_" + yCha +"_"+(yCha*points[i].y - xCha * points[i].x);
				map.put(key,map.get(key)==null?1:map.get(key)+1);
			}
		}
		int max = 0 ;
		for ( Integer num : map.values() ) {
			if ( num > max ) {
				max = num;
			}
		}
		return max == 1? 2:((int)Math.sqrt(max))+2;
	}

	public int gcd(int x , int y) {
		if ( x < y ) {
			int tem = x;
			x = y;
			y = tem;
		}
		while ( y != 0 ) {
			int left = x%y;
			x = y;
			y = left;
		}
		return x;
	}

	public static void main ( String []args) {
		OneFourNine oneFourNine = new OneFourNine();
		Point [] points = new Point[6];
		points[0] = new Point(1,1);
		points[1] = new Point(3,2);
		points[2] = new Point(5,3);
		points[3] = new Point(4,1);
		points[4] = new Point(2,3);
		points[5] = new Point(1,4);
		System.out.println(oneFourNine.maxPoints(points));
	}
}

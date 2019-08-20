import java.util.ArrayList;
import java.util.List;

/**
 * Created by lideqing@xiaomi.com on 19-6-17
 */
public class TestForTest {

	public static void main ( String []args) {
		List<Long> list = new ArrayList<>();
		list.add(-1L);
		Integer s = -1;
		Long s1 = -1L;
		int s11 = 1;
		long s22 = 1L;
		System.out.println(s11==s22);
		System.out.println(list.contains(-1));
	}

}

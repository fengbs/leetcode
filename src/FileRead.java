import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lideqing@xiaomi.com on 19-7-16
 */
public class FileRead {
	private static double VALUE = 0.5d;

	public static Map<String,Double> readFile(String file) {
		Map<String,Double> map = new TreeMap<>();
		try {

			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				String []arr = str.split(",");
				map.put(arr[0] + "_" + arr[2],Double.valueOf(arr[6]));
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static Map<String,Double> readRealFile(String file) {
		Map<String,Double> map = new TreeMap<>();
		try {

			FileReader fr = new FileReader(file);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				String []arr = str.split(",");
				map.put(arr[2] + "_" + arr[1].replace("\"",""),Double.valueOf(arr[0]));
			}
			bf.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main( String []args ) {
		String path = "/home/fengbs/lideqing/zhuanzhuan/";
		Map<String,Double> m2018 = FileRead.readFile(path + "2018.csv");
		Map<String,Double> m2019 = FileRead.readFile(path + "2019.csv");
		Map<String,Double> mReal = FileRead.readRealFile(path + "staging.csv");
		List<String> misList = new ArrayList<>();
		System.out.println("=========================以下数据差值大于"+VALUE+"(数据工厂的-数据库中的)==============");
		for ( String key : mReal.keySet() ) {
			//System.out.println(key + "  " + mReal.get(key));
			//System.out.println(key + "  " + mReal.get(key));
			if ( m2018.containsKey(key) ) {
				if ( Math.abs(m2018.get(key) - mReal.get(key)) > VALUE ) {
					System.out.println( key + "  数据工厂:" + m2018.get(key) + "  数据库:" + mReal.get(key) + "  差:" + (m2018.get(key) - mReal.get(key)));
				}
			} else if (m2019.containsKey(key)) {
				if ( Math.abs(m2019.get(key) - mReal.get(key)) > VALUE ) {
					System.out.println( key + "  数据工厂:" + m2019.get(key) + "  数据库:" + mReal.get(key) + "  差:" + (m2019.get(key) - mReal.get(key)));
				}
			} else {
				misList.add(key);
			}
		}

		System.out.println("=========================以下数据工厂存在，数据库中不存在==============");
		Double sum = 0.0;
		for ( String key : m2018.keySet() ) {
			if ( !mReal.containsKey(key) && m2018.get(key) > VALUE  ) {
				sum += m2018.get(key);
				System.out.println(key + " " + m2018.get(key));
			}
		}
		for ( String key : m2019.keySet() ) {
			if ( !mReal.containsKey(key) && m2019.get(key) > VALUE ) {
				sum += m2019.get(key);
				System.out.println(key + " " + m2019.get(key));
			}
		}

		System.out.println("miss sum:" + sum );
	}
}
